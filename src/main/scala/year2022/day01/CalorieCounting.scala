package com.martinbrosenberg.adventofcode
package year2022.day01

import year2022.AdventOfCodeDay

import scala.io.Source
import scala.util.Using

object CalorieCounting extends AdventOfCodeDay(1) {
  private val sortedTotals = Using.resource(Source.fromResource(inputUri)) { resource =>
    val lines = resource.getLines()

    var elfTotals = Vector.empty[Int]
    while (lines.hasNext) {
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
