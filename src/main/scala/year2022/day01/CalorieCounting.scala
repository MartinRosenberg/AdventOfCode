package com.martinbrosenberg.adventofcode
package year2022.day01

import scala.io.Source
import scala.util.Using

object CalorieCounting extends App {
  val sortedTotals = Using.resource(Source.fromResource("year2022/day01/input")) { resource =>
    val lines = resource.getLines()

    var elfTotals = Vector.empty[Int]
    while (lines.nonEmpty) {
      elfTotals :+= lines
        .takeWhile(!_.isBlank)
        .map(_.toInt)
        .sum
    }

    elfTotals.sorted(Ordering.Int.reverse)
  }

  println(s"Part 1: ${sortedTotals.head}")
  println(s"Part 2: ${sortedTotals.take(3).sum}")
}
