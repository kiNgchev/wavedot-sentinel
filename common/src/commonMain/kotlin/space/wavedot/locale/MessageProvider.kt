package space.wavedot.locale

public expect object MessageProvider {
    public val stringsProvider: LocalizedStringsProvider

    public fun getMessage(key: String, locale: Locale, vararg args: Any): String
}