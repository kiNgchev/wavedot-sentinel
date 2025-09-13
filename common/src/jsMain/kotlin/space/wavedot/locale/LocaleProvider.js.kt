package space.wavedot.locale

public actual object LocaleProvider {
    public actual val fallbackLocale: Locale = Locale.EN_US

    public actual fun getLocaleString(locale: Locale, key: String): String {
        TODO("Not yet implemented")
    }
}