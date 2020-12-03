package de.synth.value

/**
 * A boolean coming from or going to json. This means, it can represent itself
 * as a json and as a Boolean.
 *
 * This class is immutable and thread-safe.
 */
class JsonBoolean private constructor(
    private val lazyValue: Lazy<Boolean>,
    private val lazyJson: Lazy<String>,
    private val lazyIsValid: Lazy<Boolean>
) : JsonValue<Boolean> {
    constructor(json: String) :
        this(
            lazy {
                when (json) {
                    TRUE_VALUE -> true
                    FALSE_VALUE -> false
                    else -> throw IllegalStateException(
                        "Failed to parse the string to a boolean. " +
                            "It should've been true or false, but is: " +
                            json
                    )
                }
            },
            lazy { json },
            lazy { json == TRUE_VALUE || json == FALSE_VALUE }
        )

    private companion object {
        const val TRUE_VALUE = "true"
        const val FALSE_VALUE = "false"
    }

    /**
     * The value as a Boolean.
     * @throws IllegalStateException if the boolean couldn't be parsed
     * ([isValid] == false).
     */
    override val value: Boolean
        get() = lazyValue.value

    override val json: String
        get() = lazyJson.value

    /**
     * Whether [json] is a correct json boolean.
     */
    override val isValid: Boolean
        get() = lazyIsValid.value

    override fun toString() = "${javaClass.simpleName}($json)"
}