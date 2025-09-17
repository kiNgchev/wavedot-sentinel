package space.wavedot.locale

import java.util.MissingResourceException
import java.util.ResourceBundle

public actual object LocalizedStringsProvider {
    private val fallbackLocale: Locale = Locale.EN_US
    private var bundles: Array<ResourceBundle> = arrayOf()

    public actual fun getLocalizedString(key: String, locale: Locale): String {
        bundles.filter { it.locale == locale.toJavaLocale() }.forEach {
            try {
                return it.getString(key)
            } catch (_: MissingResourceException) {
                return@forEach
            }
        }

        return getFallbackLocaleLocalizedString(key)
    }

    public actual fun createBundle(baseName: String): Boolean {
        val locales = Locale.entries
        val pairs = locales.map {
            baseName to it.toJavaLocale()
        }

        pairs.forEach { (baseName, locale) ->
            bundles += ResourceBundle.getBundle(baseName, locale)
        }

        return true
    }

    public fun getFallbackLocaleLocalizedString(key: String): String {
        bundles.filter { it.locale == fallbackLocale.toJavaLocale() }.forEach {
            try {
                return it.getString(key)
            } catch (_: MissingResourceException) {
                return@forEach
            }
        }
        return key
    }
}

public fun Locale.toJavaLocale(): java.util.Locale {
    return when (this) {
        Locale.EN_US -> java.util.Locale.ENGLISH
        Locale.RU_RU -> java.util.Locale.Builder().setLanguage("ru").setRegion("RU").build()
    }
}