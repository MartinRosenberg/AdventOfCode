package com.martinbrosenberg.adventofcode
package year2022.day2

import scala.io.Source
import scala.util.Using

object RockPaperScissors_Part1 extends App {
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

  Using(Source.fromResource("year2022/day2/input"))(
    _.getLines()
      .toVector.view
      .map(_.trim)
      .map(_.split("\\s"))
      .map(_.map(getMovePoints))
      .foldLeft(0) { case (total, Array(opp, self)) =>
        total + self + getOutcomePoints(opp, self)
      }
  ).foreach(println)
}
