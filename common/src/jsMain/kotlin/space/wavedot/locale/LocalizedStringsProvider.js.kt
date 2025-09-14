package space.wavedot.locale

public actual object LocalizedStringsProvider {
    public actual val fallbackLocale: Locale = Locale.EN_US

    private var bundles: Array<Bundle> = arrayOf()

    public actual fun getLocalizedString(locale: Locale, key: String): String {
        bundles.filter { it.locale == locale }.forEach {
            return it[key] ?: return@forEach
        }
        //TODO: Ask fallback locale bundle
        return "not found"
    }
}