package de.synth.value

import de.synth.source.JsonSource
import de.synth.source.ValueSource
import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.junit.Test
import java.util.function.Supplier
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

// TODO: Switch to junit5 or something from kotlin
class JsonBooleanTest {
    /*
    constructor:
     */
    @Test(expected = IllegalArgumentException::class)
    fun invalidStringThrows() {
        JsonBoolean("FALSE")
    }

    @Test
    fun invalidLazyDoesntFail() {
        JsonBoolean(JsonSource { "FALSE" })
    }

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

    @Test
    fun sourceChangesValue() {
        var source = "true"
        val bool = JsonBoolean(JsonSource { source })
        assertEquals(true, bool.value)
        source = "false"
        assertEquals(false, bool.value)
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

    @Test
    fun valueChangesValue() {
        var source = true
        val bool = JsonBoolean(ValueSource { source })
        assertEquals("true", bool.json)
        source = false
        assertEquals("false", bool.json)
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidJsonSourceThrows() {
        JsonBoolean(JsonSource { "damio" }).json
    }

    /*
    isValid:
     */
    @Test
    fun valueIsValid() = assertTrue(JsonBoolean(false).isValid)


    @Test
    fun jsonIsValid() = assertTrue(JsonBoolean("true").isValid)


    @Test
    fun isNotValid() = assertFalse(
        JsonBoolean(JsonSource { "TRUE" }).isValid
    )

    @Test
    fun notValidToValid() {
        var source = "true"
        val bool = JsonBoolean(JsonSource { source })
        assertTrue(bool.isValid)
        source = "tru"
        assertFalse(bool.isValid)
    }

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
        .withGenericPrefabValues(ValueSource::class.java) {
            a -> ValueSource { a }
        }
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
    fun invalidToString() {
        val value: () -> String = { "dmienf" }
        assertEquals("JsonBoolean(${value()})", JsonBoolean(value).toString())
    }
}
