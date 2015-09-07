package main.scala.com.github.crakjie.sbtsparkplugin
import sbt._
import Keys._

object SparkPlugin extends sbt.AutoPlugin {
  
  override def trigger = allRequirements
  
	object autoImport {
	  lazy val sparkHome = settingKey[String]("The directory of your spark containing /bin")
    lazy val submitOptions = settingKey[String]("Here you can writes every submit params not implemented in this plugin")
		lazy val submit = taskKey[Unit]("Spark submit")
	}
	
	import autoImport._
	
	
	
	override lazy val projectSettings = Seq(
      submitOptions := "",
	    sparkHome := ".",
	    submit := {
		  val jars =  (dependencyClasspath in Runtime).value.files.map(_.getAbsolutePath).filterNot(_.endsWith("target/scala-2.11/classes"))
		  val strJars = jars.mkString(",")
		  val (art, file) = packagedArtifact.in(Compile, packageBin).value
		  //Calculate the main class parameter
		  val mainOp = (mainClass in Runtime).value match {
		    case None => ""
		    case Some(clazz) => "--class " + clazz 
		  }
		  val cmd =  sparkHome.value+"/bin/spark-submit "+mainOp+"  --jars " + strJars +" " + file.getAbsolutePath + " " + submitOptions
      if(logLevel.value == Level.Debug) {
        streams.value.log.debug(cmd)
      }

		  cmd !
		}
	)

}