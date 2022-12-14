package com.martinbrosenberg.adventofcode
package year2022.day4

import year2022.UsingLines

object CampCleanup_Part2 extends App {
  UsingLines("year2022/day4/input").map(_
    .map(_.split("[-,]").map(_.toInt))
    .count { case Array(aMin, aMax, bMin, bMax) =>
      bMin <= aMax && aMin <= bMax
    }
  ).foreach(println)
}
