package de.synth.value

/**
 * A class for the conversion of a json number to a float.
 */
class JsonFloat(private val stringRepresentation: String) : JsonValue<Float> {
    override fun asObject(): Float =
            if (stringRepresentation.matches(Regex("[0-9]"))) {
                throw NumberFormatException("The number must be a float, but is an int ($stringRepresentation)")
            } else {
                java.lang.Float.parseFloat(stringRepresentation)
            }

    override fun isValid(): Boolean =
            stringRepresentation.matches(
                    Regex("[0-9]+.[0-9]+")
            )
}