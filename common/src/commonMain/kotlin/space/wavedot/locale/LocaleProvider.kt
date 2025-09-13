package space.wavedot.locale

public expect object LocaleProvider {
    public val fallbackLocale: Locale

    public fun getLocaleString(locale: Locale, key: String): String
}