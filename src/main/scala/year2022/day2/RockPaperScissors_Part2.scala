package com.martinbrosenberg.adventofcode
package year2022.day2

import scala.io.Source
import scala.util.Using

object RockPaperScissors_Part2 extends App {
  val Points = Map(
    "B X" -> 1, "C X" -> 2, "A X" -> 3,
    "A Y" -> 4, "B Y" -> 5, "C Y" -> 6,
    "C Z" -> 7, "A Z" -> 8, "B Z" -> 9,
  )

  Using(Source.fromResource("year2022/day2/input"))(
    _.getLines()
      .toVector.view
      .map(_.trim)
      .filterNot(_.isBlank)
      .map(Points)
      .sum
  ).foreach(println)
}
