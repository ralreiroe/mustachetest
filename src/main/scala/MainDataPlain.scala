
object MainDataPlain extends App {

  import org.trimou.engine.MustacheEngineBuilder
  val mustache = MustacheEngineBuilder.newBuilder.build.compileMustache("Hello {{this}}!")
  println(mustache.render("world and goodbye"))

}