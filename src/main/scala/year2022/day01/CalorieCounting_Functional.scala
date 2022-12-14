package com.martinbrosenberg.adventofcode
package year2022.day01

import scala.io.Source
import scala.util.Using

object CalorieCounting_Functional extends App {
  val sortedTotals = Using.resource(Source.fromResource("year2022/day01/input"))(_
    .mkString
    .split("\n\n")
    .map(_
      .split("\n")
      .map(_.toInt)
      .sum
    )
    .sorted(Ordering.Int.reverse)
  )

  println(s"Part 1: ${sortedTotals.head}")
  println(s"Part 2: ${sortedTotals.take(3).sum}")
}
