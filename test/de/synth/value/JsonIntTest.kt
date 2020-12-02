package de.synth.value

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonIntTest {
    @Test
    fun allNumberAsObject() {
        (0..9).forEach {
            assertEquals(
                it,
                JsonInt(it.toString()).value,
                "Failed on number $it"
            )
        }
    }

    @Test(expected = NumberFormatException::class)
    fun failAsObject() {
        JsonInt("ds").value
    }

    @Test
    fun bigNumberAsObject() {
        13302.apply {
            assertEquals(
                this,
                JsonInt(
                    this.toString()
                ).value
            )
        }
    }

    @Test
    fun allIsValid() {
        (0..9).forEach {
            assertTrue(
                JsonInt(it.toString()).isValid,
                "Failed on number $it"
            )
        }
    }

    @Test
    fun bigNumberIsValid() {
        23843.apply {
            assertTrue(
                JsonInt(
                    this.toString()
                ).isValid
            )
        }
    }

    @Test
    fun emptyNotIsValid() {
        assertFalse(
            JsonInt(
                ""
            ).isValid
        )
    }

    @Test
    fun middleCharacterNotIsValid() {
        assertFalse(
            JsonInt(
                "3123d329"
            ).isValid
        )
    }

    @Test
    fun floatNotIsValid() {
        assertFalse(
            JsonInt(
                "3.2"
            ).isValid
        )
    }
}