import space.wavedot.locale.Locale
import space.wavedot.locale.LocalizedStringsProvider
import space.wavedot.locale.MessageProvider
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalizationTest {
    @Test
    fun `test bundle creation`() {
        assertEquals(
            LocalizedStringsProvider.createBundle("locale.test"),
            true
        )
    }

    @BeforeTest
    fun beforeTest() {
        LocalizedStringsProvider.createBundle("locale.test")
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
}