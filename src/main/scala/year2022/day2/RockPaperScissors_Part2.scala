package com.martinbrosenberg.adventofcode
package year2022.day2

import scala.io.Source
import scala.util.Using

object RockPaperScissors_Part2 extends App {
  def getPoints(hint: String): Int = hint match {
    case "B X" => 1
    case "C X" => 2
    case "A X" => 3

    case "A Y" => 4
    case "B Y" => 5
    case "C Y" => 6

    case "C Z" => 7
    case "A Z" => 8
    case "B Z" => 9
  }

  Using(Source.fromResource("year2022/day2/input"))(
    _.getLines()
      .toVector.view
      .map(_.trim)
      .map(getPoints)
      .sum
  ).foreach(println)
}
