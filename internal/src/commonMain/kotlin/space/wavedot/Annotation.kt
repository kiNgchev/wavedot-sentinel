package space.wavedot

import kotlin.RequiresOptIn.Level.ERROR
import kotlin.RequiresOptIn.Level.WARNING
import kotlin.annotation.AnnotationRetention.BINARY
import kotlin.annotation.AnnotationTarget.*

/** [DslMarker] for Wavedot DSLs. */
@DslMarker
@Retention(BINARY)
@Target(CLASS)
public annotation class WavedotDsl

/**
 * Marks an API in preview mode.
 */
@MustBeDocumented
@RequiresOptIn("This API is in preview mode and may be not stable.", level = WARNING)
@Retention(BINARY)
@Target(CLASS, PROPERTY, CONSTRUCTOR, FUNCTION, TYPEALIAS)
public annotation class WavedotPreview

/**
 * Marks an API for internal use only.
 */
@MustBeDocumented
@RequiresOptIn("This API is intended for internal use only.", level = ERROR)
@Retention(BINARY)
@Target(CLASS, PROPERTY, FUNCTION, TYPEALIAS)
public annotation class WavedotInternal