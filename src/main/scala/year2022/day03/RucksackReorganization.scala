package com.martinbrosenberg.adventofcode
package year2022.day03

import scala.io.Source
import scala.util.Using

object RucksackReorganization extends App {
  def getPriority(item: Char): Int =
    item.toInt - (if (item.isLower) 96 else 38)

  val data =
    Using(Source.fromResource("year2022/day03/input"))(_.getLines().toVector)

  data.map(_
    .map(line => line.splitAt(line.length / 2))
    .map { case (a, b) => a.toSet.intersect(b.toSet).head }
    .map(getPriority)
    .sum
  ).foreach { sum =>
    println(s"Part 1: $sum")
  }

  data.map(_
    .map(_.toSet)
    .grouped(3)
    .map(_.reduce(_ intersect _))
    .map(_.head)
    .map(getPriority)
    .sum
  ).foreach { sum =>
    println(s"Part 2: $sum")
  }
}
