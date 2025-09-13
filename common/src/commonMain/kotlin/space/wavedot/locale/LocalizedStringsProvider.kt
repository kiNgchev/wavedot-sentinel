package space.wavedot.locale

public expect object LocalizedStringsProvider {
    public val fallbackLocale: Locale

    public fun getLocalizedString(locale: Locale, key: String): String

}

public fun getBaseNames(): List<String> = listOf("default")