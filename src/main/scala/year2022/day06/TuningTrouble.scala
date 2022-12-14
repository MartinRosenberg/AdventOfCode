package com.martinbrosenberg.adventofcode
package year2022.day06

import scala.io.Source
import scala.util.Using

object TuningTrouble extends App {
  val chars = Using.resource(Source.fromResource("year2022/day06/input"))(_.mkString)

  def getMarkerIndex(nChars: Int): Int =
    chars.sliding(nChars).indexWhere(cs => cs == cs.distinct) + nChars

  println(s"Part 1: ${getMarkerIndex(4)}")
  println(s"Part 2: ${getMarkerIndex(14)}")
}
