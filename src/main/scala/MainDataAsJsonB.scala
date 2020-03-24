import javax.json.bind.JsonbBuilder

object MainDataAsJsonB extends App {
  import org.trimou.engine.MustacheEngineBuilder


  case class Customer(firstName: String, lastName: String, age: Int)
  val jsonString = """
{
                     |    "firstName": "Jan",
                     |    "lastName": "Novy",
                     |    "age": 30,
                     |}""".stripMargin

  val res: Customer = JsonbBuilder.create().fromJson(jsonString, classOf[Customer])
  //JSON Binding provider org.eclipse.yasson.JsonBindingProvider not found
  println(res)

  val compiledMustacheTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)
  println(compiledMustacheTemplate.render(res))

}