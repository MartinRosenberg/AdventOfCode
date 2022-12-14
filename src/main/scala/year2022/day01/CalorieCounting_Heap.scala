package com.martinbrosenberg.adventofcode
package year2022.day01

import scala.collection.mutable
import scala.io.Source
import scala.util.Using

object CalorieCounting_Heap extends App {
  val top3 = Using.resource(Source.fromResource("year2022/day01/input")) { resource =>
    val lines = resource.getLines()

    val elfTotals = mutable.PriorityQueue.empty[Int]
    while (lines.nonEmpty) {
      elfTotals += lines
        .takeWhile(!_.isBlank)
        .map(_.toInt)
        .sum
    }

    (1 to 3).map(_ => elfTotals.dequeue())
  }

  println(s"Part 1: ${top3.head}")
  println(s"Part 2: ${top3.sum}")
}
