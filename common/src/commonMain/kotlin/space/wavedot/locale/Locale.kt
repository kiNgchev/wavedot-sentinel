package space.wavedot.locale

public enum class Locale(
    public val language: String,
    public val country: String,
    public val code: String,
    public val nativeName: String,
    public val englishName: String,
) {
    EN_US("en", "US", "en_US", "English", "English"),
    RU_RU("ru", "RU", "ru_RU", "Русский", "Russian"),
}

public fun parse(value: String): Locale {
    Locale.entries.forEach { locale ->
        if (locale.name.equals(value, ignoreCase = true)
            || locale.language.equals(value, ignoreCase = true)
            || locale.code.equals(value, ignoreCase = true)
            || locale.nativeName.equals(value, ignoreCase = true)
            || locale.englishName.equals(value, ignoreCase = true)
        ) return locale
    }

    return Locale.EN_US
}