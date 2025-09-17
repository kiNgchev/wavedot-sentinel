package space.wavedot.locale

public actual object LocalizedStringsProvider {
    private val fallbackLocale: Locale = Locale.EN_US

    private var bundles: Array<Bundle> = arrayOf()

    public actual fun getLocalizedString(key: String, locale: Locale): String {
        bundles.filter { it.locale == locale }.forEach {
            return it[key] ?: getFallbackLocaleLocalizedString(key)
        }
        return key
    }

    public actual fun createBundle(baseName: String): Boolean {
        val locales = Locale.entries
        val pairs = locales.map {
            baseName to it
        }
        pairs.forEach { (baseName, locale) ->
            bundles += Bundle(baseName, locale)
        }

        return true
    }

    public fun getFallbackLocaleLocalizedString(key: String): String {
        bundles.filter { it.locale == fallbackLocale }.forEach {
            return it[key] ?: return@forEach
        }
        return key
    }

}