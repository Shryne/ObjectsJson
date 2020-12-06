package de.synth.value

import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
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
    equals:
     */
    @Test
    fun sameEquals() {
        JsonBoolean(false).also { assertEquals(it, it) }
    }

    @Test
    fun bothValueEqual() = assertEquals(JsonBoolean(true), JsonBoolean(true))

    @Test
    fun valueJsonEqual() = assertEquals(JsonBoolean("true"), JsonBoolean(true))

    @Test
    fun bothValueUnequal() = assertNotEquals(
        JsonBoolean(true), JsonBoolean(false)
    )

    @Test
    fun valueJsonUnequal() = assertNotEquals(
        JsonBoolean(false), JsonBoolean("true")
    )

    @Test
    fun differentObjectUnequal() = assertNotEquals(
        true as Any, JsonBoolean(true) as Any
    )

    /*
    hashCode:
     */

    @Test
    fun equalsHashCodeVerified() = EqualsVerifier
        .simple()
        .withGenericPrefabValues(Lazy::class.java) { a -> lazy { a }}
        .forClass(JsonBoolean::class.java)
        .withIgnoredFields("lazyJson")
        .suppress(Warning.NULL_FIELDS)
        .verify()

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