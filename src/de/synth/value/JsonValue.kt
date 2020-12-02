package de.synth.value

/**
 * A json value. Only primitive json objects are values. Other ones (object and array) are based on other values and
 * are not primitive because of this.
 */
interface JsonValue<T> {
    /**
     * The object of this json value.
     */
    val value: T

    /**
     * Checks whether the json value is valid (correct parsable).
     */
    fun isValid(): Boolean
}