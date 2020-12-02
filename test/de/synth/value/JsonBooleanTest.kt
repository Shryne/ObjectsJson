package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonBooleanTest {
    @Test
    fun falseAsObject() {
        assertEquals(
            false,
            JsonBoolean("false").value
        )
    }

    @Test
    fun trueAsObject() {
        assertEquals(
            true,
            JsonBoolean("true").value
        )
    }

    @Test(expected = IllegalStateException::class)
    fun failAsObject() {
        JsonBoolean("FALSE").value
    }

    @Test
    fun falseIsValid() {
        assertFalse(JsonBoolean("TRUE").isValid())
    }

    @Test
    fun trueIsValid() {
        assertTrue(JsonBoolean("true").isValid())
    }
}