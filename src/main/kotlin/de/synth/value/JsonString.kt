package de.synth.value

/**
 * A class for the conversion of a json string to a string object.
 *
 * This class is immutable and thread-safe.
 */
// TODO: Check if all characters are supported in the json specification
// TODO: What about line breaks?
class JsonString(private val stringRepresentation: String) : JsonValue<String> {
    override val value: String
        get() = stringRepresentation

    /**
     * The string is valid, if it starts and ends with a " and contains something in between.
     */
    override val isValid: Boolean
        get() = stringRepresentation.startsWith("\"") && stringRepresentation.endsWith("\"")

    override val json: String
        get() = TODO("Not yet implemented")

    override fun toString() = "${javaClass.simpleName}($stringRepresentation)"
}