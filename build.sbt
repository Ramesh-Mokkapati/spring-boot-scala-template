val springBootVersion = "2.5.5"
val jacksonVersion = "2.12.3"
val currentDirectory = new java.io.File(".").getCanonicalPath

Global / onChangedBuildSource := ReloadOnSourceChanges

crossTarget := baseDirectory.value / "target"

lazy val root = project
  .in(file("."))
  .settings(
    name := "spring-boot-scala-template",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.12.10",
    assembly / mainClass := Some("com.github.rameshmokkapati.springbootscalatemplate.ExampleApp"),
    assembly / assemblyJarName := "spring-boot-scala-template.jar",
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion exclude("org.springframework.boot", "spring-boot-starter-tomcat"),
    libraryDependencies += "org.springframework" % "spring-context" % springBootVersion,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion % "compile",
    libraryDependencies += "org.springframework.boot" % "spring-boot-actuator-autoconfigure" % springBootVersion % "compile",
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-jetty" % springBootVersion,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion % Test,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-websocket" % springBootVersion exclude("org.springframework.boot", "spring-boot-starter-tomcat"),
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-amqp" % "2.6.1",
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
    libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % jacksonVersion,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test,
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.8.1" % Test,
    libraryDependencies += "net.aichler" % "jupiter-interface" % "0.9.1" % Test,
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11",
    libraryDependencies += "org.scala-lang" % "scala-library" % "2.12.10",
    libraryDependencies += "org.hsqldb" % "hsqldb" % "2.5.0",
    libraryDependencies += "com.squareup.okhttp3" % "logging-interceptor" % "4.9.0" ,
    libraryDependencies += "de.siegmar" % "fastcsv" % "1.0.3" ,
    libraryDependencies += "org.apache.avro" % "avro" % "1.9.2" ,
    libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.30.1" ,
    libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "8.4.1.jre14" ,
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.20",
    libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "4.9.0" ,
    libraryDependencies += "com.squareup.okhttp3" % "logging-interceptor" % "4.9.0" ,
    libraryDependencies += "com.squareup.retrofit2" % "retrofit" % "2.9.0" ,
    libraryDependencies += "com.squareup.retrofit2" % "adapter-scala" % "2.9.0" ,
    libraryDependencies += "com.squareup.retrofit2" % "converter-jackson" % "2.9.0" ,
    libraryDependencies += "com.squareup.retrofit2" % "converter-scalars" % "2.9.0",
    libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.13.1",
    libraryDependencies += "io.jsonwebtoken" % "jjwt" % "0.6.0",
    libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.1",
    libraryDependencies += "com.sun.xml.bind" %  "jaxb-impl" % "2.1.3",
    libraryDependencies += "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.8.2"
  )

ThisBuild / javacOptions ++= Seq("-source", "14")
ThisBuild / resolvers += Resolver.jcenterRepo

ThisBuild / assemblyMergeStrategy := {
  case PathList(ps @ _*) if ps.contains("module-info.class") =>
    MergeStrategy.concat
  case PathList("META-INF", "spring-configuration-metadata.json") =>
    MergeStrategy.concat
  case PathList("META-INF", "additional-spring-configuration-metadata.json") =>
    MergeStrategy.concat
  case PathList("META-INF", "spring.handlers")  => MergeStrategy.concat
  case PathList("META-INF", "spring.schemas")   => MergeStrategy.concat
  case PathList("META-INF", "spring.factories") => MergeStrategy.concat
  case PathList("META-INF", "web-fragment.xml") => MergeStrategy.concat
  case PathList("META-INF", "spring-autoconfigure-metadata.properties") =>
    MergeStrategy.concat
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "." + artifact.extension
}
