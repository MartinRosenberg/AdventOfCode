package com.martinbrosenberg.adventofcode
package year2022.day01

import year2022.AdventOfCodeDay

import scala.io.Source
import scala.util.Using

object CalorieCounting_Functional extends AdventOfCodeDay(1) {
  private val sortedTotals = Using.resource(Source.fromResource(inputUri))(_
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
