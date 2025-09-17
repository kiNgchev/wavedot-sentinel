package space.wavedot.test

import space.wavedot.format
import kotlin.test.Test
import kotlin.test.assertEquals

class FormatTest {
    @Test
    fun formatString() {
        val expect = "{0} idk {1}".format(1, 2)
        val actual = "1 idk 2"
        assertEquals(expect, actual)
    }
}