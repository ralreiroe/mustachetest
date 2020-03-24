import com.google.gson.JsonParser


import com.google.gson.{JsonElement => GsonJsonElement, JsonParser => GsonJsonParser}

object MainDataAsGson extends App {
  import org.trimou.engine.MustacheEngineBuilder

  private val parser: GsonJsonParser = new JsonParser()
  val gsonJsonElement: GsonJsonElement = parser.parse(
    """
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
      |}""".stripMargin)
  val compiledMustacheTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)
  println(compiledMustacheTemplate.render(gsonJsonElement))

}