package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonNumberTest {
    @Test
    fun someNumberAsObject() {
        assertEquals(
            0.0.toFloat(),
            JsonNumber("0.0").value
        )
    }

    @Test(expected = NumberFormatException::class)
    fun intFailAsObject() {
        JsonNumber("1").value
    }

    @Test(expected = NumberFormatException::class)
    fun characterFailAsObject() {
        JsonNumber("sda").value
    }

    @Test
    fun intIsValid() {
        assertFalse(
            JsonNumber("5").isValid
        )
    }

    @Test
    fun simpleFloatIsValid() {
        assertTrue(
            JsonNumber("1.6").isValid
        )
    }

    @Test
    fun longFloatIsValid() {
        assertTrue(
            JsonNumber("438.2309392").isValid
        )
    }

    @Test
    fun multiplePointsIsValid() {
        assertFalse(
            JsonNumber(
                "0.043.42"
            ).isValid
        )
    }

    @Test
    fun allNumberAsObject() {
        (0..9).forEach {
            assertEquals(
                it,
                JsonNumber(it.toString()).value,
                "Failed on number $it"
            )
        }
    }

    @Test(expected = NumberFormatException::class)
    fun failAsObject() {
        JsonNumber("ds").value
    }

    @Test
    fun bigNumberAsObject() {
        13302.apply {
            assertEquals(
                this,
                JsonNumber(
                    this.toString()
                ).value
            )
        }
    }

    @Test
    fun allIsValid() {
        (0..9).forEach {
            assertTrue(
                JsonNumber(it.toString()).isValid,
                "Failed on number $it"
            )
        }
    }

    @Test
    fun bigNumberIsValid() {
        23843.apply {
            assertTrue(
                JsonNumber(
                    this.toString()
                ).isValid
            )
        }
    }

    @Test
    fun emptyNotIsValid() {
        assertFalse(
            JsonNumber(
                ""
            ).isValid
        )
    }

    @Test
    fun middleCharacterNotIsValid() {
        assertFalse(
            JsonNumber(
                "3123d329"
            ).isValid
        )
    }

    @Test
    fun floatNotIsValid() {
        assertFalse(
            JsonNumber(
                "3.2"
            ).isValid
        )
    }
}
