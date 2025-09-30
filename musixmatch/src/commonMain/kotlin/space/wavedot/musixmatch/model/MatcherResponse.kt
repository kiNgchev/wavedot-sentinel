package space.wavedot.musixmatch.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class LyricsGetResponse(
    public val message: Message
)

@Serializable
public data class Message(
    public val body: Body,
    public val header: Header
)

@Serializable
public data class Body(
    public val lyrics: Lyrics
)

@Serializable
public data class Lyrics(
    public val explicit: Int,
    @SerialName("lyrics_body")
    public val lyricsBody: String,
    @SerialName("lyrics_copyright")
    public val lyricsCopyright: String,
    @SerialName("lyrics_id")
    public val lyricsId: Int,
    @SerialName("lyrics_language")
    public val lyricsLanguage: String,
    @SerialName("pixel_tracking_url")
    public val pixelTrackingUrl: String,
    @SerialName("region_restriction")
    public val regionRestriction: RegionRestriction,
    @SerialName("script_tracking_url")
    public val scriptTrackingUrl: String,
    @SerialName("updated_time")
    public val updatedTime: String,
)

@Serializable
public data class RegionRestriction(
    public val allowed: List<String>,
    public val blocked: List<String>,
)

@Serializable
public data class Header(
    @SerialName("execute_time")
    public val executeTime: Double,
    @SerialName("status_code")
    public val statusCode: Int,
)