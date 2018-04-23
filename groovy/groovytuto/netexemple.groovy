/* ==> le lien du forum
https://stackoverflow.com/questions/33606900/execute-curl-using-groovy
*/

/* ==> la question du forum
def json = """{
        "description": "string",
        "mode": "DEFAULT",
        "name": "string",
        "start_time": "2015-11-05T13:26:40.626Z",
        "tags": [
                "string"
        ]
    }"""
    process = ["curl", "-k", "--user", "user:pass", "-X", "POST", "-H", "Content-Type: application/json", "-d", "${json}", "https://<api_uri>/launch"].execute().text
*/

/* ==> la réponse du forum
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.http.auth.*
import wslite.rest.*

def client = new RESTClient("https://<api_uri>/")
client.authorization = new HTTPBasicAuthorization("user", "pass")
def response = client.post(path: "/launch",headers: ['Content-Type': 'application/json']) {
    json description: "string", mode: "DEFAULT", name: "string", start_time: "2015-11-05T13:26:40.626Z", tags: [ "string" ] 
}

*/


/* ==> un autre exemple
modified script
def proc = "curl https://hostname/manager/text/list/".execute()
// cURL uses error output stream for progress output.
Thread.start { System.err << proc.err }
// Wait until cURL process finished and continue with the loop.
proc.waitFor()
*/


/* http://mrhaki.blogspot.fr/2008/12/using-groovy-to-invoke-curl-and-use.html
// Start from today.
def today = new Date()
// Determine date value for the next month.
// The TimeCategory makes it possible to use the 1.month syntax.
def nextMonth
use (org.codehaus.groovy.runtime.TimeCategory) {
  nextMonth = today + 1.month
}
// Loop through every day from now to the next month.
for (day in today..nextMonth) {
  println "Starting import for ${day.format('dd MMMM yyyy')}."
  // Define cURL process with correct arguments.
  def proc = "curl -o log/${day.format('yyyy-MM-dd')}.log "
           + "http://servername/import-data/${day.format('yyyy-MM-dd')}"
           .execute()
  // cURL uses error output stream for progress output.
  Thread.start { System.err << proc.err }
  // Wait until cURL process finished and continue with the loop.
  proc.waitFor()
}
*/
