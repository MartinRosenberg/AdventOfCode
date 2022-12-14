package com.martinbrosenberg.adventofcode
package year2022.day07

import year2022.AdventOfCodeDay
import year2022.day07.FsNode.FsDir

import scala.io.Source
import scala.util.Using

sealed trait FsNode
object FsNode {
  case class FsDir(contents: List[FsNode] = List.empty) extends FsNode
  case class FsFile(size: Int) extends FsNode
}

object NoSpaceLeftOnDevice extends AdventOfCodeDay(7) {
  def doThing(line: Seq[String]): Any = line match {
    case "$" :: "ls" :: Nil => ???
    case "$" :: "cd" :: ".." :: Nil => ???
    case "$" :: "cd" :: path :: Nil => ???
    case "dir" :: name :: Nil => ???
    case size :: name :: Nil => ???
  }

  override protected val inputUri: String = "year2022/day07/sample"

  val fs = FsDir()
  var pointer: String = ""

  Using.resource(Source.fromResource(inputUri)) { resource =>
    val lines = resource
      .getLines()
      .map(_.split(' ').toVector)

    while (lines.hasNext) {
      val line = lines.next()
      if (line(0) == "$" && line(1) == "cd") {
        pointer = line(2)
      } else if
    }
  }


//  val lines = Using.resource(Source.fromResource(inputUri))(_
//    .getLines()
//    .map(_.split(' ').toVector)
//  )
//
//  val fs = FsDir()
//  while (lines.hasNext) {
//    val line = lines.next()
//    println(line)
//    if (line(1) == "ls") {
//      println(lines.takeWhile(_.head != "$"))
//    }
//  }
}
