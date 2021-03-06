package de.synth.value

/**
 * A json value. Only primitive json objects are values. Other ones (object and array) are based on other values and
 * are not primitive because of this.
 */
interface JsonValue<T> {
    /**
     * The object of this json value. This method will throw an exception if
     * the json isn't parsable. Use [isValid] beforehand to check this.
     */
    val value: T

    /**
     * The json version of the value. This method will throw an exception if
     * the json isn't parsable. Use [isValid] beforehand to check this.
     */
    val json: String

    /**
     * Whether the json value is valid (correctly parsable).
     */
    val isValid: Boolean
}