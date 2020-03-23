resolvers += "Fashionid private plugins" at "https://fidrepository.jfrog.io/fidrepository/sbt-plugins-release-local"
resolvers += "Fashionid private plugins" at "https://fidrepository.jfrog.io/fidrepository/libs-release-local"
resolvers += "Thirdparty libraries at JBoss" at "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"
credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
addSbtPlugin("de.fashionid"  % "fid-package-plugin" % "2.0.31")
addSbtPlugin("org.scoverage" % "sbt-scoverage"      % "1.5.1")
addSbtPlugin("org.scalameta" % "sbt-scalafmt"       % "2.2.1")
