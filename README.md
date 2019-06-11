# egghead

A simple Kotlin based (ktor) backend that hits wikipedia's api for random articles, converts the article's summary to audio through Google Cloud's
Text to Speech API and returns the audio to the caller, all in about 50 lines of code.



#### prerequisites ####
1. You'll need a Google Cloud account, with the [text-to-speech api enabled.](https://cloud.google.com/text-to-speech/docs/quickstart-protocol)
2. You'll also need to create service account credentials, and set your GOOGLE_APPLICATION_CREDENTIALS environment variable to point to the 
location of your service account credentials. The link in step 1 has more information.
    * example: `export GOOGLE_APPLICATION_CREDENTIALS="/home/mancini/gcp_creds.json"`

#### deployment instructions ####
1. `git clone https://github.com/mancini0/egghead.git`
2.  `cd egghead && ./gradlew run`

The application should be accessible at localhost:8080.
