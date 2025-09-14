package space.wavedot.locale


internal class Bundle(internal val baseName: String, internal val locale: Locale) {
    private val localizedStrings: HashMap<String, String> = HashMap()

    init {
        val baseName = this.baseName.replace(".", "/").split("/")
        val locale = this.locale.code
        TODO("Add localized strings loading")
    }

    internal operator fun get(key: String): String? = localizedStrings[key]
    internal operator fun set(key: String, value: String) {
        localizedStrings[key] = value
    }
}