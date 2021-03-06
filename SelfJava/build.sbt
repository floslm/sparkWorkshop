name := "Simple Project"

version := "1.0"

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.2"

