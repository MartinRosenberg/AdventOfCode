package com.martinbrosenberg.adventofcode
package year2022.day6

import scala.io.Source
import scala.util.Using

object TuningTrouble_Part1 extends App {
  Using(Source.fromResource("year2022/day6/input")) { resource =>
    resource.sliding(4).indexWhere(cs => cs == cs.distinct) + 4
  }.foreach(println)
}
