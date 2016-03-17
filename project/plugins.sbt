logLevel := Level.Warn

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

addSbtPlugin("com.earldouglas"  % "xsbt-web-plugin" % "1.1.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.2")