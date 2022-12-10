package com.martinbrosenberg.adventofcode
package year2022.day1

import scala.collection.mutable
import scala.io.Source
import scala.util.Using

object CalorieCounting_Heap extends App {
  Using(Source.fromResource("year2022/day1/input")) { resource =>
    val lines = resource.getLines().map(_.trim)

    val elfTotals = mutable.PriorityQueue.empty[Int]
    while (lines.nonEmpty) {
      elfTotals += lines.takeWhile(!_.isBlank).map(_.toInt).sum
    }

    (1 to 3).map(_ => elfTotals.dequeue())
  }.foreach { top3 =>
    println(s"Part 1: ${top3.head}")
    println(s"Part 2: ${top3.sum}")
  }
}
