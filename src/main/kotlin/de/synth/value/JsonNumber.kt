package de.synth.value

import de.synth.source.JsonSource
import de.synth.source.ValueSource
import java.util.function.Supplier

/**
 * A class for the conversion of a json number to a float.
 *
 * This class is immutable and thread-safe.
 */
// TODO: How long is an int/float allowed to be? What about leading zeros?
class JsonNumber private constructor(
    private val lazyValue: ValueSource<Number>,
    private val lazyJson: JsonSource,
    private val lazyIsValid: Supplier<Boolean>
) : JsonValue<Number> {
    constructor(value: Number) :
        this(
            ValueSource { value },
            JsonSource { "$value" },
            { true }
        )

    constructor(json: String) :
        this(
            TODO("Not yet implemented"),
            TODO("Not yet implemented"),
            TODO("Not yet implemented")
        )

    override val value: Number get() = lazyValue.get()

    override val isValid: Boolean get() = lazyIsValid.get()

    override val json: String get() = lazyJson.get()

    override fun toString() = "${javaClass.simpleName}(${lazyJson.get()})"
}
