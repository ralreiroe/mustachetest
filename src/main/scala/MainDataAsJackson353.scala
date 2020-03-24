import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr353.JSR353Module
import javax.json.{JsonObject => JavaxJsonObj}


object MainDataAsJackson353 extends App {
  import org.trimou.engine.MustacheEngineBuilder

  private val objectMapper = new ObjectMapper()
  objectMapper.registerModule(new JSR353Module())

  private val jsonString =
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
      |}""".stripMargin

  private val jsObj: JavaxJsonObj = objectMapper.readValue(jsonString, classOf[JavaxJsonObj])   //ability to pass javax JsonObjects around


  val compiledTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)
  println(compiledTemplate.render(jsObj))    //this works - just like with glassfish

}