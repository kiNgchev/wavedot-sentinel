package space.wavedot.locale

public actual object MessageProvider {
    public actual val stringsProvider: LocalizedStringsProvider = LocalizedStringsProvider

    public actual fun getMessage(key: String, locale: Locale, vararg args: Any): String {
        return stringsProvider.getLocalizedString(key, locale).format(args)
    }
}