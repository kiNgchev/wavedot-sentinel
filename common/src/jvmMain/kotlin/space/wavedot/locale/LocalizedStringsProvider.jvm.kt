package space.wavedot.locale

import java.util.ResourceBundle

public actual object LocalizedStringsProvider {
    public actual val fallbackLocale: Locale = Locale.EN_US
    private var bundles: Array<ResourceBundle> = arrayOf()

    init {
        val baseNames = getBaseNames()
        val locales = Locale.entries
        var pairs =  baseNames.flatMap { baseName -> locales.map { locale -> baseName to locale.toJavaLocale() } }
        pairs.forEach { (baseName, locale) ->
            bundles += ResourceBundle.getBundle(baseName, locale)
        }
    }

    public actual fun getLocalizedString(locale: Locale, key: String): String {
        bundles.filter { it.locale == locale.toJavaLocale() }.forEach {
            return it.getString(key)
        }

        //TODO: Ask fallback locale bundle
        return "not found"
    }
}

public fun Locale.toJavaLocale(): java.util.Locale {
    return when (this) {
        Locale.EN_US -> java.util.Locale.ENGLISH
        Locale.RU_RU -> java.util.Locale.of("ru")
    }
}