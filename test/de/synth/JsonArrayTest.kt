package de.synth

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonArrayTest {
    @Test
    fun emptyIsValid() {
        assertTrue(
                JsonArray("[]").isValid()
        )
    }

    @Test
    fun oneElementIsValid() {
        assertTrue(
                JsonArray("[4]").isValid()
        )
    }

    @Test
    fun twoElementsIsValid() {
        assertTrue(
                JsonArray("[2, 6]").isValid()
        )
    }

    @Test
    fun notArrayIsValid() {
        assertFalse(JsonArray("").isValid())
    }

    @Test
    fun emptyIterator() {
        assertFalse(
                JsonArray("[]").iterator().hasNext()
        )
    }

    @Test
    fun oneIterator() {
        val iterator = JsonArray("[25]").iterator()

        assertTrue(iterator.hasNext())
        assertEquals("25", iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun twoIterator() {
        val iterator = JsonArray("[5,2]").iterator()

        assertTrue(iterator.hasNext())
        assertEquals("5", iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals("2", iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun multipleElementsIterator() {
        assertEquals(
                listOf("\"a\"", "ba", "44", "null", "das"),
                JsonArray("[\"a\", ba, 44, null, das]").iterator().asSequence().toCollection(mutableListOf())
        )
    }
}