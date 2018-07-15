package de.synth.value

/**
 * A class for the conversion of a json int into a int object.
 */
// TODO: How long is an int/float allowed to be? What about leading zeros?
class JsonInt(private val stringRepresentation: String) : JsonValue<Int> {
    /**
     * @throws NumberFormatException if the number couldn't be parsed.
     */
    override fun asObject(): Int =
            Integer.parseInt(stringRepresentation)

    override fun isValid(): Boolean =
            stringRepresentation.matches(
                    Regex("[0-9]+")
            )
}