package de.synth.value

/**
 * A class for the conversion of a json int into a int object.
 */
class JsonInt(private val strinRepresentation: String) : JsonValue<Int> {
    override fun javaType(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isValid(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}