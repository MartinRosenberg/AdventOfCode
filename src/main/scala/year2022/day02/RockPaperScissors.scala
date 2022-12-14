package com.martinbrosenberg.adventofcode
package year2022.day02

import scala.io.Source
import scala.util.Using

object RockPaperScissors extends App {
  val lines = Using.resource(Source.fromResource("year2022/day02/input"))(_.getLines().toVector)

  // Part 1

  def getMovePoints(letter: String): Int = letter match {
    case "A" | "X" => 1
    case "B" | "Y" => 2
    case "C" | "Z" => 3
  }

  def getOutcomePoints(opp: Int, self: Int): Int = self - opp match {
    case 1 | -2 => 6
    case 0 => 3
    case 2 | -1 => 0
  }

  val xyzAsMoves = lines
    .map(_.split(" "))
    .map(_.map(getMovePoints))
    .foldLeft(0) { case (total, Array(opp, self)) =>
      total + self + getOutcomePoints(opp, self)
    }

  println(s"Part 1: $xyzAsMoves")

  // Part 2

  val Points = Map(
    "B X" -> 1, "C X" -> 2, "A X" -> 3,
    "A Y" -> 4, "B Y" -> 5, "C Y" -> 6,
    "C Z" -> 7, "A Z" -> 8, "B Z" -> 9,
  )

  val xyzAsResolutions = lines
    .map(Points)
    .sum

  println(s"Part 2: $xyzAsResolutions")
}
