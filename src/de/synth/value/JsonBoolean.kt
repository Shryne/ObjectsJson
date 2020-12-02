package de.synth.value

/**
 * A boolean coming from or going to json. This means, it can represent itself
 * as a json and as a Boolean.
 *
 * This class is immutable and thread-safe.
 */
class JsonBoolean(private val stringRepresentation: String) : JsonValue<Boolean> {
    private companion object {
        const val TRUE_VALUE = "true"
        const val FALSE_VALUE = "false"
    }

    /**
     * @throws IllegalStateException if the boolean couldn't be parsed.
     */
    override val value: Boolean
        get() = when (stringRepresentation) {
            TRUE_VALUE -> true
            FALSE_VALUE -> false
            else -> throw IllegalStateException(
                "Failed to parse the string to a boolean. " +
                    "It should've been true or false, but is: $stringRepresentation"
            )
        }

    override val isValid: Boolean
        get() = stringRepresentation == TRUE_VALUE ||
            stringRepresentation == FALSE_VALUE

    override fun toString() = "${javaClass.simpleName}($stringRepresentation)"
}