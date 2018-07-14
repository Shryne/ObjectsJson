package de.synth

import de.synth.source.ObjectSource
import de.synth.source.Source
import de.synth.value.JsonValue

/**
 * Represents a json object. It can be used to either for output and input of a json object.
 */
// TODO: JsonObject could be a source, too
class JsonObject(private val source: Source) : Iterable<String> {
    constructor(vararg keyValues : Pair<String, JsonValue<*>>) : this(ObjectSource(*keyValues))

    fun get(key: String): String = source.get(key)
    fun has(key: String): Boolean = source.has(key)

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