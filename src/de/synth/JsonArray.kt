package de.synth

/**
 * A class for the conversion of a json array into a json object.
 *
 * This class is immutable and thread-safe.
 */
class JsonArray(private val stringRepresentation: String) : Iterable<String> {
    fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<String> =
            object : Iterator<String> {
                override fun hasNext(): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun next(): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
}