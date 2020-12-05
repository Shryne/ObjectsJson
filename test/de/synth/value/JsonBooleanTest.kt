package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// TODO: Switch to junit5 or something from kotlin
class JsonBooleanTest {
    /*
    value:
     */
    @Test
    fun falseValue() = assertEquals(false, JsonBoolean("false").value)

    @Test
    fun trueValue() = assertEquals(true, JsonBoolean("true").value)

    @Test(expected = IllegalArgumentException::class)
    fun failValue() {
        JsonBoolean("FALSE").value
    }
    /*
    json:
     */
    @Test
    fun fromValueToJson() = assertEquals("true", JsonBoolean(true).json)

    @Test(expected = IllegalArgumentException::class)
    fun inValidJsonToJson() {
        JsonBoolean("FALSE").json
    }

    /*
    isValid:
     */
    @Test
    fun falseIsValid() = assertFalse(JsonBoolean("TRUE").isValid)


    @Test
    fun trueIsValid() = assertTrue(JsonBoolean("true").isValid)


    @Test
    fun isNotValid() = assertFalse(JsonBoolean("TRUE").isValid)

    /*
    toString:
     */
    @Test
    fun fromValueToString() = assertEquals(
        "JsonBoolean(true)", JsonBoolean(true).toString()
    )

    @Test
    fun inValidToString() {
        "dmienf".also {
            assertEquals("JsonBoolean($it)", JsonBoolean(it).toString())
        }
    }
}