package space.wavedot.test

import space.wavedot.locale.Bundle
import space.wavedot.locale.Locale
import space.wavedot.locale.LocalizedStringsProvider
import space.wavedot.locale.MessageProvider
import space.wavedot.locale.delegate.i18n
import space.wavedot.locale.parse
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class LocalizationTest {
    @Test
    fun `test bundle creation`() {
        assertEquals(
            LocalizedStringsProvider.createBundle("locale.test"),
            true
        )
    }

    @Test
    fun `test message provider get by key`() {
        val expect = MessageProvider.getMessage("test", Locale.RU_RU)
        val actual = "тест"
        assertEquals(expect, actual)
    }

    @Test
    fun `test fallback localization get by key`() {
        val expectExits = MessageProvider.getMessage("exists", Locale.RU_RU)
        val actualExits = "exists"
        assertEquals(expectExits, actualExits)
        val expectNoExits = MessageProvider.getMessage("noExists", Locale.RU_RU)
        val actualNoExits = "noExists"
        assertEquals(expectNoExits, actualNoExits)
    }

    @Test
    fun `test localization delegate`() {
        val expect by i18n("exists", Locale.RU_RU)
        val actual = "exists"
        assertEquals(expect, actual)
    }

    @Test
    fun `test parse locale`() {
        var expect = parse("ru")
        var actual = Locale.RU_RU
        assertEquals(expect, actual)

        expect = parse("en")
        actual = Locale.EN_US
        assertEquals(expect, actual)

        expect = parse("en_US")
        actual = Locale.EN_US
        assertEquals(expect, actual)

        expect = parse("ru_US")
        actual = Locale.RU_RU
        assertFails {
            assertEquals(expect, actual)
        }

        expect = parse("Русский")
        actual = Locale.RU_RU
        assertEquals(expect, actual)

        expect = parse("Russian")
        actual = Locale.RU_RU
        assertEquals(expect, actual)
    }
}