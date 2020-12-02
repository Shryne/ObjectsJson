package de.synth.value

/**
 * A class for the conversion of a json int into a int object.
 *
 * This class is immutable and thread-safe.
 */
// TODO: How long is an int/float allowed to be? What about leading zeros?
class JsonInt(private val stringRepresentation: String) : JsonValue<Int> {
    /**
     * @throws NumberFormatException if the number couldn't be parsed.
     */
    override val value: Int
        get() = Integer.parseInt(stringRepresentation)

    override val isValid: Boolean
        get() = stringRepresentation.matches(
            Regex("[0-9]+")
        )

    override fun toString() = "${javaClass.simpleName}($stringRepresentation)"
}