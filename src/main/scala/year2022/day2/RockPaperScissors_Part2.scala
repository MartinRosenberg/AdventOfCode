package com.martinbrosenberg.adventofcode
package year2022.day2

import year2022.UsingLines

object RockPaperScissors_Part2 extends App {
  val Points = Map(
    "B X" -> 1, "C X" -> 2, "A X" -> 3,
    "A Y" -> 4, "B Y" -> 5, "C Y" -> 6,
    "C Z" -> 7, "A Z" -> 8, "B Z" -> 9,
  )
  
  UsingLines("year2022/day2/input").map(_
    .map(Points)
    .sum
  ).foreach(println)
}
