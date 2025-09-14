package space.wavedot.test

import space.wavedot.locale.Bundle
import space.wavedot.locale.Locale
import kotlin.test.Test

class LocalizationTest {
    @Test
    fun `test create bundle localization`() {
        val bundle: Bundle = Bundle("locale.test", Locale.RU_RU)
    }
}