package de.synth.value

/**
 * A class for the conversion of a json boolean into a boolean object.
 */
class JsonBoolean(private val stringRepresentation: String) : JsonValue<Boolean> {

    override fun javaType(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}