package space.wavedot.locale.delegate

import space.wavedot.locale.Locale
import space.wavedot.locale.MessageProvider
import space.wavedot.locale.parse
import kotlin.reflect.KProperty

public class I18N(
    public val key: String,
    public val locale: Locale,
    public val args: Array<Any>
) {
    private val messageProvider: MessageProvider = MessageProvider

    public operator fun getValue(instance: Any?, property: KProperty<*>): String =
        messageProvider.getMessage(key, locale, args)

    public operator fun setValue(instance: Any?, property: KProperty<*>, value: String): Nothing =
        throw UnsupportedOperationException("You can't set $value to $instance")
}

public fun i18n(key: String, locale: Locale, vararg args: Any): I18N =
    I18N(key, locale, args.toSet().toTypedArray())

public fun i18n(key: String, locale: String, vararg args: Any): I18N =
    i18n(key, parse(locale), args)