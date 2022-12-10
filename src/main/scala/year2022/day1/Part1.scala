package com.martinbrosenberg.adventofcode
package year2022.day1

import scala.io.Source
import scala.util.Using

object Part1 extends App {
  Using(Source.fromResource("year2022/day1/input.txt")) { resource =>
    val lines = resource.getLines().map(_.trim)

    var elfTotals = Vector.empty[Int]
    while (lines.nonEmpty) {
      elfTotals :+= lines.takeWhile(!_.isBlank).map(_.toInt).sum
    }

    elfTotals.max
  }.foreach(println)
}