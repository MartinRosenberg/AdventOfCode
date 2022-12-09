package com.martinbrosenberg.adventofcode
package year2022.day1

import scala.collection.immutable.Queue
import scala.collection.mutable.ArrayBuffer
import scala.io.{BufferedSource, Source}

object Part2 extends App {
  val resource = Source.fromResource("year2022/day1/input.txt")
  val lines = resource.getLines().map(_.trim)
  var elfTotals = Queue.empty[Int]
  while (lines.nonEmpty) {
    elfTotals :+= lines.takeWhile(!_.isBlank).map(_.toInt).sum
  }
  val max3Calories = elfTotals.sortWith(_ > _).take(3).sum
  resource.close()
  println(max3Calories)
}