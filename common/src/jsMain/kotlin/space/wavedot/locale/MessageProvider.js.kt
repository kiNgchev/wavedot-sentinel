package space.wavedot.locale

public actual class MessageProvider(provider: LocalizedStringsProvider) {
    public actual val stringsProvider: LocalizedStringsProvider = provider

    public actual fun getMessage(locale: Locale, vararg args: Any): String {
        TODO("Not yet implemented")
    }
}
