package de.synth.value

/**
 * A class for the conversion of a json string to a string object.
 */
class JsonString(private val stringRepresentation: String) : JsonValue<String> {
    override fun asObject(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}