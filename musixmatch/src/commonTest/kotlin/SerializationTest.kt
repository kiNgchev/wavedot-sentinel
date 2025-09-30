import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import space.wavedot.musixmatch.model.Body
import space.wavedot.musixmatch.model.Header
import space.wavedot.musixmatch.model.Lyrics
import space.wavedot.musixmatch.model.LyricsGetResponse
import space.wavedot.musixmatch.model.Message
import space.wavedot.musixmatch.model.RegionRestriction
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTest {
    @OptIn(ExperimentalSerializationApi::class)
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    @Test
    fun testSerialization() {
        val expect = json.encodeToString(LyricsGetResponse(Message(
            Body(
                Lyrics(
                    1,
                    "He said, \"Let's get out of this town\nDrive out of the city, away from the crowds\"\nI thought, \"Heaven can't help me now\"\nNothing lasts forever\nBut this is gonna take me down\n\nHe's so tall, and handsome as hell\nHe's so bad, but he does it so well\nI can see the end as it begins\nMy one condition is\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your wildest dreams, ah-ah, ha\nWildest dreams, ah-ah, ha\n\nI said, \"No one has to know what we do\"\nHis hands are in my hair, his clothes are in my room\nAnd his voice is a familiar sound\nNothing lasts forever\nBut this is getting good now\n\nHe's so tall, and handsome as hell\nHe's so bad, but he does it so well\nAnd when we've had our very last kiss\nMy last request, it is\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your wildest dreams, ah-ah, ha (ah-ah, ha)\nWildest dreams, ah-ah, ha\n\nYou'll see me in hindsight, tangled up with you all night\nBurning it down\nSomeday when you leave me, I bet these memories\nFollow you around\n\nYou'll see me in hindsight, tangled up with you all night\nBurning (burning) it (it) down (down)\nSomeday when you leave me, I bet these memories\nFollow (follow) you (you) around (around)\n(Follow you around)\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again, even if it's just pretend\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your (just pretend, just pretend)\nWildest dreams, ah-ah, ha (ah-ah-ah-ah)\nWildest dreams, ah-ah, ha\n(Even if it's just in your) wildest dreams, ah-ah, ha\n\nIn your wildest dreams, ah-ah, ha",
                    "Writer(s): Taylor Swift, Shellback, Max Martin\nCopyright: Taylor Swift Music, Mxm Music Ab, Sony/atv Tree Publishing\nLyrics powered by www.musixmatch.com",
                    33540930,
                    "en",
                    "https://tracking.musixmatch.com/t1.0/m_img/e_0/sn_0/l_33540930/su_0/rs_0/...zLt8GECCNyZAt2JlGj5CFosV7FJ6v8sOeDIxwCqPAozD4zBcgrQg/",
                    RegionRestriction(
                        listOf("XW"),
                        listOf()
                    ),
                    "https://tracking.musixmatch.com/t1.0/m_js/e_0/sn_0/l_33540930/su_0/rs_0/...X0_nlfnK3pQQtj_0NCndT4ssxzlKC_cOnn58vHIv_ZwmCEWVkA/",
                    "2024-04-08T02:07:16Z"
                )
            ),
            Header(0.01480507850647, 200)
        )))
        val actual = """
            {
              "message": {
                "body": {
                  "lyrics": {
                    "explicit": 1,
                    "lyrics_body": "He said, \"Let's get out of this town\nDrive out of the city, away from the crowds\"\nI thought, \"Heaven can't help me now\"\nNothing lasts forever\nBut this is gonna take me down\n\nHe's so tall, and handsome as hell\nHe's so bad, but he does it so well\nI can see the end as it begins\nMy one condition is\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your wildest dreams, ah-ah, ha\nWildest dreams, ah-ah, ha\n\nI said, \"No one has to know what we do\"\nHis hands are in my hair, his clothes are in my room\nAnd his voice is a familiar sound\nNothing lasts forever\nBut this is getting good now\n\nHe's so tall, and handsome as hell\nHe's so bad, but he does it so well\nAnd when we've had our very last kiss\nMy last request, it is\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your wildest dreams, ah-ah, ha (ah-ah, ha)\nWildest dreams, ah-ah, ha\n\nYou'll see me in hindsight, tangled up with you all night\nBurning it down\nSomeday when you leave me, I bet these memories\nFollow you around\n\nYou'll see me in hindsight, tangled up with you all night\nBurning (burning) it (it) down (down)\nSomeday when you leave me, I bet these memories\nFollow (follow) you (you) around (around)\n(Follow you around)\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again, even if it's just pretend\n\nSay you'll remember me standing in a nice dress\nStaring at the sunset, babe\nRed lips and rosy cheeks\nSay you'll see me again\nEven if it's just in your (just pretend, just pretend)\nWildest dreams, ah-ah, ha (ah-ah-ah-ah)\nWildest dreams, ah-ah, ha\n(Even if it's just in your) wildest dreams, ah-ah, ha\n\nIn your wildest dreams, ah-ah, ha",
                    "lyrics_copyright": "Writer(s): Taylor Swift, Shellback, Max Martin\nCopyright: Taylor Swift Music, Mxm Music Ab, Sony/atv Tree Publishing\nLyrics powered by www.musixmatch.com",
                    "lyrics_id": 33540930,
                    "lyrics_language": "en",
                    "pixel_tracking_url": "https://tracking.musixmatch.com/t1.0/m_img/e_0/sn_0/l_33540930/su_0/rs_0/...zLt8GECCNyZAt2JlGj5CFosV7FJ6v8sOeDIxwCqPAozD4zBcgrQg/",
                    "region_restriction": {
                      "allowed": [
                        "XW"
                      ],
                      "blocked": []
                    },
                    "script_tracking_url": "https://tracking.musixmatch.com/t1.0/m_js/e_0/sn_0/l_33540930/su_0/rs_0/...X0_nlfnK3pQQtj_0NCndT4ssxzlKC_cOnn58vHIv_ZwmCEWVkA/",
                    "updated_time": "2024-04-08T02:07:16Z"
                  }
                },
                "header": {
                  "execute_time": 0.01480507850647,
                  "status_code": 200
                }
              }
            }
        """.trimIndent()

        assertEquals(expect, actual)
    }
}