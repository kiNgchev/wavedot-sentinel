package space.wavedot.locale

public expect class MessageProvider {
    public val stringsProvider: LocalizedStringsProvider

    public fun getMessage(locale: Locale, vararg args: Any): String
}