package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonBooleanTest {
    @Test
    fun falseJavaType() {
        assertEquals(
                false,
                JsonBoolean("false").asObject()
        )
    }

    @Test
    fun trueJavaType() {
        assertEquals(
                true,
                JsonBoolean("true").asObject()
        )
    }

    @Test(expected = IllegalStateException::class)
    fun failJavaType() {
        JsonBoolean("FALSE").asObject()
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