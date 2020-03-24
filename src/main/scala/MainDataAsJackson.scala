import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.google.gson.JsonParser
import javax.json.{Json, JsonStructure}
import org.trimou.Mustache


//if I pass a com.fasterxml.jackson.databind.JsonNode into the mustache template, I get no error but no substitution either

object MainDataAsJackson extends App {
  import org.trimou.engine.MustacheEngineBuilder

  private val jacksonJsonElement: JsonNode = new ObjectMapper().readTree(
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
  val compiledTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)

  jacksonJsonElement
  println(compiledTemplate.render(jacksonJsonElement))    //no substituion!

}