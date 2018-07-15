package de.synth.target

/**
 * The output target of a json object. It can be used to export a json object onto a file.
 */
interface Target {
    /**
     * Adds the given string to the target.
     * @param string the string to add on the target.
     */
    fun add(string: String)
}