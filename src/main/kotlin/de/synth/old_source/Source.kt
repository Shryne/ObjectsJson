package de.synth.old_source

/**
 * The interface for a json source. It can be a file, real objects or anything else.
 */
interface Source : Iterable<String> {
    /**
     * Finds the value for the given key. This method should only be used, when there is really a value for the given
     * key. Otherwise use [has].
     * @return the value of the key as a string. Example:
     * <p>{ "someKey": 414 } // get("someKey") => "414"</p>
     * To parse the returned key, one has to use the json value classes.
     * @throws NoSuchFieldException if there isn't any value for the given string.
     */
    fun get(key: String): String

    /**
     * @return True, if the source contains a value for the given key.
     */
    // TODO: Has and get will both search for the key. This should be optimized.
    fun has(key: String): Boolean
}