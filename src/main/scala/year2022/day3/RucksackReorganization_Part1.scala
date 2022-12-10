package com.martinbrosenberg.adventofcode
package year2022.day3

import scala.io.Source
import scala.util.Using

object RucksackReorganization_Part1 extends App {
  def getPriority(item: Char): Int =
    if (item.isLower) item.toInt - 96
    else item.toInt - 38

  Using(Source.fromResource("year2022/day3/input"))(
    _.getLines()
      .toVector.view
      .map(_.trim)
      .filterNot(_.isBlank)
      .map(line => line.splitAt(line.length / 2))
      .map { case (a, b) => a.toSet.intersect(b.toSet).head }
      .map(getPriority)
      .sum
  ).foreach(println)
}
