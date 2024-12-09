package com.martinbrosenberg.adventofcode
package year2024.day01

object HistorianHysteria {

  private def readLines(): Seq[String] =
    io.Source.fromResource("year2024/day01.wsv").getLines().toSeq

  /** Part 1 */
  def totalDistance(): Int =
    readLines()
      .map(_.split(" {3}").map(_.toInt))
      .transpose
      .map(_.sorted)
      .transpose
      .map(pair => (pair(0) - pair(1)).abs)
      .sum

  @main def run(): Unit = {
    println(s"Day 1 Part 1: ${totalDistance()}")
  }
}
