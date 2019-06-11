

import com.google.cloud.texttospeech.v1beta1.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson



fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {

    val voices = listOf(SsmlVoiceGender.MALE, SsmlVoiceGender.FEMALE, SsmlVoiceGender.NEUTRAL)
    val accents = listOf("en-US", "en-AU","en-GB")
    val client = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        engine{
            followRedirects = true
        }
    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
         get("/")  {
            val wikiNugget = client.get<WikiNugget> {
                url("https://en.wikipedia.org/api/rest_v1/page/random/summary")
                contentType(ContentType.Application.Json)
            }
             val ttsClient = TextToSpeechClient.create()

             val input = SynthesisInput.newBuilder()
                 .setText(wikiNugget.extract)
                 .build()

             val voice = VoiceSelectionParams.newBuilder()
                 .setLanguageCode(accents.random())
                 .setSsmlGender(voices.random())
                 .build()
             val audioConfig = AudioConfig.newBuilder()
                 .setAudioEncoding(AudioEncoding.OGG_OPUS)
                 .build()

             call.respondBytes(ContentType.Audio.OGG, HttpStatusCode.OK, suspend {ttsClient.synthesizeSpeech(input,voice,audioConfig).audioContent.toByteArray()})
        }
    }
}

class WikiNugget(val title: String, val extract: String, val pageid: Long)
