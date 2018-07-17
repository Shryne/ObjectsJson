package de.synth

/**
 * A class for the conversion of a json array into a json object.
 *
 * This class is immutable and thread-safe.
 */
class JsonArray(private val stringRepresentation: String) : Iterable<String> {
    override fun iterator(): Iterator<String> =
            object : Iterator<String> {
                private var string: String = stringRepresentation.substring(1, stringRepresentation.length - 1)

                override fun hasNext(): Boolean = string.any { it != ' ' }

                override fun next(): String {
                    if (!hasNext()) {
                        throw NoSuchFieldException(
                                "The array has no fields anymore. Array: $stringRepresentation"
                        )
                    }
                    val end = string.indexOfUnbordered('"') { it == ',' }
                    val result = string
                            .substring(
                                    string.indexOfFirst { it != ' ' },
                                    if (end == -1) string.length else end
                            )
                    string = if (end == -1) "" else string.substring(end + 1)
                    return result
                }
            }

    fun isValid(): Boolean = stringRepresentation.startsWith("[") && stringRepresentation.endsWith("]")

    // TODO: Find something better
    private fun String.indexOfUnbordered(borderChar: Char, predicate: (Char) -> Boolean): Int {
        var closed = true
        var borderIgnored = false
        forEachIndexed { index, c ->
            if (c == borderChar && !borderIgnored) {
                closed = !closed
            } else if (closed && predicate(c)) {
                return index
            } else {
                borderIgnored = (c == '\\')
            }
        }
        return -1
    }
}