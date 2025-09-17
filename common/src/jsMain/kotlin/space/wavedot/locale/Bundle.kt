package space.wavedot.locale

private external val require: dynamic
private val fs: dynamic = require("fs")

internal class Bundle(internal val baseName: String, internal val locale: Locale) {
    private val localizedStrings: HashMap<String, String> = HashMap()

    init {
        val baseName = this.baseName.replace(".", "/")
        val locale = this.locale.code
        val file = "./kotlin/${baseName}_${locale}.properties"
        val content = fs.readFileSync(file, encoding = "utf-8").toString()

        content.split("\n").forEach {
            val arr = it.split("=")

            if (it.isEmpty() or it.isBlank())
                return@forEach
            if (arr.size != 2)
                throw IllegalArgumentException("Invalid bundle string: $it")

            val (key, value) = arr
            localizedStrings[key] = value
        }
    }

    internal operator fun get(key: String): String? = localizedStrings[key]
    internal operator fun set(key: String, value: String) {
        localizedStrings[key] = value
    }
}