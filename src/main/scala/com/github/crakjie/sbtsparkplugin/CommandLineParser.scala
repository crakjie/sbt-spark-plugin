package com.github.crakjie.sbtsparkplugin

import scala.collection.immutable.IndexedSeq
import scala.util.matching.Regex

/**
  * Created by admin on 30/03/2016.
  */
object CommandLineParser {

  private val commandRegex = """['"]((?:\\['"]|.)+?)['"]|([^\s"']+)""".r

  private def extractGroups(m :Regex.Match): IndexedSeq[String] = {
    for {
      i <- 1 to m.groupCount
      str <- Option(m.group(i))
    } yield str
  }

  def parse(cmd :String ) : Seq[String] = {
    for {
      m <- commandRegex findAllMatchIn cmd
      str <- extractGroups(m)
    } yield str
  }.toSeq
}
