package com.martinbrosenberg.adventofcode
package year2022.day03

import year2022.AdventOfCodeDay

import scala.io.Source
import scala.util.Using

object RucksackReorganization extends AdventOfCodeDay(3) {
  def getPriority(item: Char): Int =
    item.toInt - (if (item.isLower) 96 else 38)

  val lines = Using.resource(Source.fromResource(inputUri))(_.getLines().toVector)

  val part1 = lines
    .map(line => line.splitAt(line.length / 2))
    .map { case (a, b) => a.toSet.intersect(b.toSet).head }
    .map(getPriority)
    .sum
  println(s"Part 1: $part1")
  
  val part2 = lines
    .map(_.toSet)
    .grouped(3)
    .map(_.reduce(_ intersect _))
    .map(_.head)
    .map(getPriority)
    .sum
  println(s"Part 2: $part2")
}
