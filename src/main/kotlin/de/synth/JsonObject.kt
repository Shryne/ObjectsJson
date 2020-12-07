package de.synth

import de.synth.old_source.ObjectSource
import de.synth.old_source.Source
import de.synth.target.Target
import de.synth.value.JsonValue

/**
 * Represents a json object. It can be used to either for output and input of a
 * json object.
 *
 * This class is immutable and thread-safe.
 */
// TODO: Can a JsonObject be removed, because the source is doing everything?
class JsonObject(private val source: Source) : Source, Iterable<String>, Exportable {
    constructor(vararg keyValues: Pair<String, JsonValue<*>>) : this(ObjectSource(*keyValues))

    override fun get(key: String): String = source.get(key)
    override fun has(key: String): Boolean = source.has(key)

    override fun iterator(): Iterator<String> =
        object : Iterator<String> {
            override fun hasNext(): Boolean {
                TODO("not implemented")
                //val x: String = "das".substring(1, 2)
            }

            override fun next(): String {
                TODO("not implemented")
            }
        }

    override fun exportTo(target: Target) {
        TODO("not implemented")
    }
}
