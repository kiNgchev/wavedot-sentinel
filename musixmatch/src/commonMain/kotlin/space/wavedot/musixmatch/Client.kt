package space.wavedot.musixmatch

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import space.wavedot.WavedotPreview
import space.wavedot.musixmatch.model.LyricsGetResponse

public const val BASE_URL: String = "https://api.musixmatch.com"

public class MusixMatchClient(
    private val token: String,
    private val http: HttpClient = HttpClient(CIO),
    private val json: Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }
) {
    init {
        require(token.isNotBlank() and token.isNotEmpty()) {
            "Musix match token is invalid"
        }
    }

    @WavedotPreview
    public suspend fun getTrack(qTrack: String, qArtist: String): LyricsGetResponse {
        val response = http.get {
            url("$BASE_URL/ws/1.1/matcher.lyrics.get?apikey=$token&q_track=$qTrack&q_artist=$qArtist")
        }

        return json.decodeFromString(LyricsGetResponse.serializer(), response.bodyAsText())
    }

    @WavedotPreview
    public suspend fun getTrack(isrcId: String): LyricsGetResponse {
        val response = http.get {
            url("$BASE_URL/ws/1.1/matcher.lyrics.get?apikey=$token&track_isrc=$isrcId")
        }

        return json.decodeFromString(LyricsGetResponse.serializer(), response.bodyAsText())
    }
}