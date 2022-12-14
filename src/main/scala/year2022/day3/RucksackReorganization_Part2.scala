package com.martinbrosenberg.adventofcode
package year2022.day3

import year2022.UsingLines

object RucksackReorganization_Part2 extends App {
  def getPriority(item: Char): Int = item.toInt - (if (item.isLower) 96 else 38)

  UsingLines("year2022/day3/input").map(_
    .map(_.toSet)
    .grouped(3)
    .toVector.view
    .map(_.reduce(_ intersect _))
    .map(_.head)
    .map(getPriority)
    .sum
  ).foreach(println)
}
