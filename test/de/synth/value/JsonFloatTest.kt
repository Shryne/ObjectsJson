package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonFloatTest {
    @Test
    fun someNumberAsObject() {
        assertEquals(
                0.0.toFloat(),
                JsonFloat("0.0").asObject()
        )
    }

    @Test(expected = NumberFormatException::class)
    fun intFailAsObject() {
        JsonFloat("1").asObject()
    }

    @Test(expected = NumberFormatException::class)
    fun characterFailAsObject() {
        JsonFloat("sda").asObject()
    }

    @Test
    fun intIsValid() {
        assertFalse(
                JsonFloat("5").isValid()
        )
    }

    @Test
    fun simpleFloatIsValid() {
        assertTrue(
                JsonFloat("1.6").isValid()
        )
    }

    @Test
    fun longFloatIsValid() {
        assertTrue(
                JsonFloat("438.2309392").isValid()
        )
    }

    @Test
    fun multiplePointsIsValid() {
        assertFalse(
                JsonFloat(
                        "0.043.42"
                ).isValid()
        )
    }
}