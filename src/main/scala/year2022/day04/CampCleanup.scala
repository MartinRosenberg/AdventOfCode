package com.martinbrosenberg.adventofcode
package year2022.day04

import scala.io.Source
import scala.util.Using

object CampCleanup extends App {
  val data = Using.resource(Source.fromResource("year2022/day04/input"))(_
    .getLines()
    .toVector
    .map(_.split("[-,]").map(_.toInt))
  )

  val fullyOverlappingRanges = data.count { case Array(aMin, aMax, bMin, bMax) =>
    (aMin <= bMin && aMax >= bMax) || (aMin >= bMin && aMax <= bMax)
  }
  println(s"Part 1: $fullyOverlappingRanges")

  val overlappingRanges = data.count { case Array(aMin, aMax, bMin, bMax) =>
    bMin <= aMax && aMin <= bMax
  }
  println(s"Part 2: $overlappingRanges")
}
