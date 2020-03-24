import javax.json.bind.JsonbBuilder

object MainDataAsObject extends App {
  import org.trimou.engine.MustacheEngineBuilder


  case class Customer(firstName: String, lastName: String, age: Int)

  private val customer = Customer("Ralf", "Oenning", 30)
  println("****" + customer)

  val compiledMustacheTemplate = MustacheEngineBuilder.newBuilder.build.compileMustache("""Last name: {{lastName}}
                                                                          |Street: {{address.street}}
                                                                          |Phone numbers: {{#phoneNumbers}}{{number}}{{#iterHasNext}}, {{/iterHasNext}}{{/phoneNumbers}}
                                                                          |Type of the first phone number: {{phoneNumbers.0.type}}
                                                                          |Type of the second phone number: {{phoneNumbers.1.type}}""".stripMargin)
  println(compiledMustacheTemplate.render(customer))

}