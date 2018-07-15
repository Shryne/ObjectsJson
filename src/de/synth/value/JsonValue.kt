package de.synth.value

/**
 * A json value. Only primitive json objects are values. Other ones (object and array) are based on other values and
 * are not primitive because of this.
 */
interface JsonValue<T> {
    /**
     * @return the object of this json value.
     */
    fun asObject(): T

    /**
     * Checks whether the json value is valid (correct parsable).
     */
    fun isValid(): Boolean
}