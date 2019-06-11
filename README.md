# egghead

A simple Kotlin based [Ktor](https://ktor.io/quickstart/index.html) backend that hits Wikipedia's api for random articles, converts the article's summary to audio through Google Cloud's
Text to Speech API and returns the audio to the caller, all in about 50 lines of code.


#### prerequisites ####
1. You'll need a Google Cloud account, with the [text-to-speech api enabled.](https://cloud.google.com/text-to-speech/docs/quickstart-protocol)
2. You'll also need to create service account credentials, and set your GOOGLE_APPLICATION_CREDENTIALS environment variable to point to the 
location of your service account credentials. The link in step 1 has more information.
    * example: `export GOOGLE_APPLICATION_CREDENTIALS="/home/mancini/gcp_creds.json"`

#### deployment instructions ####
1. `git clone https://github.com/mancini0/egghead.git`
2.  `cd egghead && ./gradlew run`

The application should be accessible at localhost:8080. Note - As of June 2019, the text to speech API provides a free tier that allows one to convert 4 million characters of text into audio monthly.

#### todo ####
1. add third party license information 
2. retrieve licenses from wikipedia articles being consumed and pass the license along to caller as meta-data.

#### license ###

The MIT License

Copyright (c) 2019 Mike Mancini

Permission is hereby granted, free of charge, 
to any person obtaining a copy of this software and 
associated documentation files (the "Software"), to 
deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, 
merge, publish, distribute, sublicense, and/or sell 
copies of the Software, and to permit persons to whom 
the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice 
shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
