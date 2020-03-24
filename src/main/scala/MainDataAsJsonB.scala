import java.io.StringReader

import javax.json.{Json, JsonObject, JsonReader}

//passing a javax.json.JsonObject to compiled template works - substitution yes but with quotes
//the actual implementation is in org.glassfish.json


//https://javaee.github.io/jsonp/getting-started.html
//the libraries here are json-api and glassfish.javax.json (I thought this was Json *B*?)


//ALLES GUT ERKLAERT: APIs, reference implmentations. json-p = parsing/streaming/deserialization. json-b: mapping to own classes
//
// http://www.tutego.de/blog/javainsel/2018/07/json-serialisierung-mit-jsr-353-374-und-jsr-367/

object MainDataAsJsonB extends App {
  import org.trimou.engine.MustacheEngineBuilder

  val jsonString =     """
{
                         |    "firstName": "Jan",
                         |    "lastName": "Novy",
                         |    "age": 30,
                         |    "address": {
                         |        "street": "Nova",
                         |        "city": "Prague",
                         |        "state": "CZ",
                         |        "postalCode": "11000"
                         |    },
                         |    "phoneNumbers": [
                         |        {
                         |            "type": "home",
                         |            "number": "`42002012345"
                         |        },
                         |        {
                         |            "type": "mobile",
                         |            "number": "`420728000111"
                         |        }
                         |    ]
                         |}""".stripMargin

  val jsonReader: JsonReader = Json.createReader(new StringReader(jsonString))

  private val jsonObject: JsonObject = jsonReader.readObject()

  val compiledMustacheTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)
  println(compiledMustacheTemplate.render(jsonObject))

}