package com.martinbrosenberg.adventofcode
package year2022.day3

import scala.collection.View
import scala.io.Source
import scala.util.Using

object RucksackReorganization_Part2 extends App {
  def getPriority(item: Char): Int =
    if (item.isLower) item.toInt - 96
    else item.toInt - 38

  Using(Source.fromResource("year2022/day3/input"))(
    _.getLines()
      .toVector.view
      .map(_.trim)
      .filterNot(_.isBlank)
      .map(_.toSet)
      .grouped(3)
      .toVector.view
      .map(_.reduce(_ intersect _))
      .map(_.head)
      .map(getPriority)
      .sum
  ).foreach(println)
}
