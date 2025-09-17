package space.wavedot.locale

public expect object LocalizedStringsProvider {
    public fun getLocalizedString(key: String, locale: Locale): String

    public fun createBundle(baseName: String): Boolean
}