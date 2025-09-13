package space.wavedot.locale

public expect class MessageProvider {
    public val localeProvider: LocaleProvider

    public fun getMessage(locale: Locale, vararg args: Any): String
}