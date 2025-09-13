package space.wavedot.locale

public actual class MessageProvider(provider: LocaleProvider) {
    public actual val localeProvider: LocaleProvider = provider

    public actual fun getMessage(locale: Locale, vararg args: Any): String {
        TODO("Not yet implemented")
    }
}
