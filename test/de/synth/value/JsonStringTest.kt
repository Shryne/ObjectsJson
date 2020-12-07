package de.synth.value

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JsonStringTest {
    @Test
    fun emptyIsValid() {
        assertTrue(JsonString("\"\"").isValid)
    }

    @Test
    fun someCharactersIsValid() {
        assertTrue(JsonString("\"DSu23328das\"").isValid)
    }

    @Test
    fun multipleTextMarkersIsValid() {
        assertTrue(JsonString("\"\"\"\"").isValid)
    }

    @Test
    fun noEndMarkerIsValid() {
        assertFalse(JsonString("\"b").isValid)
    }

    @Test
    fun noStartMarkerIsValid() {
        assertFalse(JsonString("ds\"").isValid)
    }
}
