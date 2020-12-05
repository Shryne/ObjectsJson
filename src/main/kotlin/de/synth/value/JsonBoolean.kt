package de.synth.value

/**
 * A boolean coming from or going to json. This means, it can represent itself
 * as a json and as a Boolean.
 *
 * This class is immutable and thread-safe.
 */
// TODO: Constructors should be able to throw an exception if possible
// TODO: The lazy stuff should probably not be defined in this class
class JsonBoolean private constructor(
    private val lazyValue: Lazy<Boolean>,
    private val lazyJson: Lazy<String>,
    private val lazyIsValid: Lazy<Boolean>
) : JsonValue<Boolean> {
    constructor(value: Boolean) :
        this(
            lazyOf(value),
            lazyOf(value.toString()),
            lazyOf(true)
        )

    constructor(json: String) :
        this(json, lazy { json == TRUE_VALUE || json == FALSE_VALUE } )

    private constructor(json: String, lazyIsValid: Lazy<Boolean>) :
        this(
            lazy {
                when (json) {
                    TRUE_VALUE -> true
                    FALSE_VALUE -> false
                    else -> throw IllegalArgumentException(
                        "Failed to parse the string to a boolean. " +
                            "It should've been true or false, but is: " +
                            json
                    )
                }
            },
            lazyOf(json),
            lazyIsValid
        )

    private companion object {
        const val TRUE_VALUE = "true"
        const val FALSE_VALUE = "false"
    }

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

    override fun hashCode(): Int {
        TODO()
    }

    override fun equals(other: Any?): Boolean {
        TODO()
    }

    override fun toString() = "${javaClass.simpleName}(${lazyJson.value})"
}