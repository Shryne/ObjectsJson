package de.synth.value

import de.synth.source.JsonSource
import de.synth.source.ValueSource

// TODO: Constructors should be able to throw an exception if possible
/**
 * A boolean coming from or going to json. This means, it can represent itself
 * as a json and as a Boolean.
 *
 * A JsonBoolean is equal to another JsonBoolean if it is equal by [value]. If
 * [isValid] is false then they are equal by [isValid].
 *
 * Example:
 *
 *     // Boolean to json:
 *     JsonBoolean(true).json // = "true"
 *     // json to Boolean:
 *     JsonBoolean("true").value // = true
 *
 * This class is immutable and thread-safe.
 */
// TODO: At JMH unit tests
// TODO: The lazy stuff should probably not be defined in this class
class JsonBoolean private constructor(
    private val lazyValue: Lazy<Boolean>,
    private val lazyJson: Lazy<String>,
    private val lazyIsValid: Lazy<Boolean>
) : JsonValue<Boolean> {
    private companion object {
        const val TRUE_VALUE = "true"
        const val FALSE_VALUE = "false"
    }

    /**
     * Constructor to convert a boolean to the json representation.
     */
    constructor(value: Boolean) :
        this(
            lazyOf(value),
            lazyOf(value.toString()),
            lazyOf(true)
        )

    /**
     * Constructor to convert a json string to a boolean.
     * @throws IllegalArgumentException if the given string isn't a valid
     *  json boolean.
     */
    constructor(json: String) :
        this(
            when (json) {
                TRUE_VALUE -> true
                FALSE_VALUE -> false
                else -> throw IllegalArgumentException(
                    "Failed to parse the string to a boolean. " +
                        "It should've been true or false, but is: " +
                        json
                )
            }
        )

    /**
     * Constructor to take a value source. By using this constructor it's
     * possible to change the value from outside of this class:
     *
     *     // This is allowed:
     *     var value = true
     *     val bool = JsonBoolean(ValueSource { value })
     *     bool.value // => true
     *
     *     value = false
     *     bool.value // => false
     */
    constructor(valueSource: ValueSource<Boolean>) :
        this(
            lazy(valueSource::get),
            lazy(valueSource::get::toString),
            lazyOf(true)
        )

    /**
     * Constructor to take a json source. This constructor won't check if the
     * given value is a valid json. The check happens when a method is called
     * that needs the real value of the source. This allows the given source to
     * change the value after this constructor has been called.
     *
     *     // This is allowed:
     *     var value = "true"
     *     val bool = JsonBoolean(JsonSource { value })
     *     bool.value // => true
     *
     *     value = "false"
     *     bool.value // => false
     */
    constructor(jsonSource: JsonSource) :
        this(
            jsonSource,
            lazy {
                jsonSource.get().run {
                    this == TRUE_VALUE || this == FALSE_VALUE
                }
            }
        )

    /**
     * This constructor is necessary to use the isValid check. Otherwise kotlin
     * would complaint that the value can't be used before the object is
     * constructed.
     */
    private constructor(jsonSource: JsonSource, lazyIsValid: Lazy<Boolean>) :
        this(
            lazy {
                when (val value = jsonSource.get()) {
                    TRUE_VALUE -> true
                    FALSE_VALUE -> false
                    else -> throw IllegalArgumentException(
                        "Failed to parse the string to a boolean. " +
                            "It should've been true or false, but is: $value"
                    )
                }
            },
            // TODO: What happens, if the value changes when lazyIsValid is invoked and then jsonSource becomes invalid?
            lazy {
                if (lazyIsValid.value) jsonSource.get()
                else throw IllegalArgumentException(
                    "Failed to parse the string to a boolean. " +
                        "It should've been true or false, but is: " +
                        jsonSource.get()
                )
            },
            lazyIsValid
        )

    /**
     * The value as a Boolean.
     * @throws IllegalArgumentException if the boolean couldn't be parsed
     * ([isValid] == false).
     */
    override val value: Boolean
        get() = lazyValue.value

    override val json: String
        get() =
            if (lazyIsValid.value) lazyJson.value
            else {
                throw IllegalArgumentException(
                    "The given json (${lazyJson.value}) is invalid."
                )
            }

    /**
     * Whether [json] is a correct json boolean.
     */
    override val isValid: Boolean
        get() = lazyIsValid.value

    override fun hashCode() = if (isValid) value.hashCode() else 1

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        else if (other is JsonBoolean) {
            return if (!other.isValid && !isValid) true
            else other.isValid && isValid && other.value == value
        }
        return false
    }

    override fun toString() = "${javaClass.simpleName}(${lazyJson.value})"
}