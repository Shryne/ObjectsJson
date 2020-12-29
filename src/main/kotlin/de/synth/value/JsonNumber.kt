package de.synth.value

import de.synth.source.JsonSource
import de.synth.source.ValueSource
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.function.Supplier

/**
 * A class for the conversion of a json number to a float.
 *
 * This class is immutable and thread-safe.
 */
// TODO: How long is an int/float allowed to be? What about leading zeros?
class JsonNumber private constructor(
    private val lazyValue: ValueSource<Number?>,
    private val lazyJson: JsonSource,
    private val lazyIsValid: Supplier<Boolean>
) : JsonValue<Number> {
    constructor(value: Number) :
        this(
            // TODO: implement ValueSource(value). The performance may be better
            ValueSource { value },
            JsonSource { "$value" },
            { true }
        )

    constructor(json: String) :
        this(
            json.toBigDecimalOrNull().run {
                if (this == null) {
                    throw IllegalArgumentException(
                        "Failed to parse the string ($json) to a number."
                    )
                } else {
                    ValueSource { this }
                }
            },
            JsonSource { json },
            { true }
        )

    override val value: Number get() =
        lazyValue.get().run {
            this ?: throw IllegalArgumentException(
                "Failed to parse the string ($json) to a number."
            )
        }

    override val isValid: Boolean get() = lazyIsValid.get()

    override val json: String get() = lazyJson.get()

    override fun toString() = "${javaClass.simpleName}(${lazyJson.get()})"
}
