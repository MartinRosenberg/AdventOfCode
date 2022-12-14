package com.martinbrosenberg.adventofcode
package year2022.day3

import year2022.UsingLines

object RucksackReorganization_Part1 extends App {
  def getPriority(item: Char): Int = item.toInt - (if (item.isLower) 96 else 38)

  UsingLines("year2022/day3/input").map(_
    .map(line => line.splitAt(line.length / 2))
    .map { case (a, b) => a.toSet.intersect(b.toSet).head }
    .map(getPriority)
    .sum
  ).foreach(println)
}
