package de.synth.value

/**
 * A class for the conversion of a json boolean into a boolean object.
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
    override fun asObject(): Boolean =
        when (stringRepresentation) {
            TRUE_VALUE -> true
            FALSE_VALUE -> false
            else -> throw IllegalStateException(
                "Failed to parse the string to a boolean. " +
                    "It should've been true or false, but is: $stringRepresentation"
            )
        }

    override fun isValid(): Boolean =
        stringRepresentation == TRUE_VALUE || stringRepresentation == FALSE_VALUE

    override fun toString() = "${javaClass.simpleName}($stringRepresentation)"
}