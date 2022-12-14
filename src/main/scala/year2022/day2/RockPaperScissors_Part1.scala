package com.martinbrosenberg.adventofcode
package year2022.day2

import year2022.UsingLines

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

  UsingLines("year2022/day2/input").map(_
    .map(_.split(" "))
    .map(_.map(getMovePoints))
    .foldLeft(0) { case (total, Array(opp, self)) =>
      total + self + getOutcomePoints(opp, self)
    }
  ).foreach(println)
}
