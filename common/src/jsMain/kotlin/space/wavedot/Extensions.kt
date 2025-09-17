package space.wavedot

public fun format(string: String, vararg args: Any): String {
    return string.format(*args)
}

public fun String.format(vararg args: Any): String {
    return this.replace(Regex("\\{(\\d+)\\}")) { matchResult ->
        val index = matchResult.groups[1]?.value?.toIntOrNull()
        if (index != null && index < args.size) {
            args[index].toString()
        } else {
            matchResult.value
        }
    }
}