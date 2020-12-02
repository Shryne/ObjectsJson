package de.synth.value

/**
 * A class for the conversion of a json number to a float.
 *
 * This class is immutable and thread-safe.
 */
class JsonFloat(private val stringRepresentation: String) : JsonValue<Float> {
    override val value: Float
        get() =
            if (stringRepresentation.matches(Regex("[0-9]"))) {
                throw NumberFormatException("The number must be a float, but is an int ($stringRepresentation)")
            } else {
                java.lang.Float.parseFloat(stringRepresentation)
            }

    override val isValid: Boolean
        get() = stringRepresentation.matches(
            Regex("[0-9]+.[0-9]+")
        )

    override val json: String
        get() = TODO("Not yet implemented")

    override fun toString() = "${javaClass.simpleName}($stringRepresentation)"
}