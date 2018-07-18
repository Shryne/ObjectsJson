package de.synth.source

import de.synth.value.JsonValue

/**
 * Json objects as a source. This can be used to turn json objects into a file.
 *
 * This class is immutable and thread-safe.
 */
class ObjectSource(private val map: Map<String, JsonValue<*>>) : Source {
    constructor(vararg keyValues: Pair<String, JsonValue<*>>) : this(mapOf(*keyValues))

    override fun get(key: String) = map[key]!!.toString()
    override fun has(key: String) = key in map

    override fun iterator(): Iterator<String> = map.values.map { it.toString() }.iterator()
}