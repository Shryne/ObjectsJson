package de.synth.value

/**
 * A json value.
 */
interface JsonValue<T> {
    /**
     * @return the Java type of this json value.
     */
    fun javaType(): T

    /**
     * Checks whether the json value is valid (correct parsable).
     */
    fun isValid(): Boolean
}