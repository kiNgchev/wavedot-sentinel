package space.wavedot.locale

public actual object LocalizedStringsProvider {
    public actual val fallbackLocale: Locale = Locale.EN_US

    public actual fun getLocalizedString(locale: Locale, key: String): String {
        TODO("Not yet implemented")
    }
}