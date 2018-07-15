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
                JsonBoolean("false").javaType()
        )
    }

    @Test
    fun trueJavaType() {
        assertEquals(
                true,
                JsonBoolean("true").javaType()
        )
    }

    @Test(expected = IllegalStateException::class)
    fun failJavaType() {
        JsonBoolean("FALSE").javaType()
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