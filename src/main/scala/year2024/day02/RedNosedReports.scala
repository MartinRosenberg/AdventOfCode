package com.martinbrosenberg.adventofcode
package year2024.day02

import java.io.FileNotFoundException

object RedNosedReports {

  // TODO: genericize this
  @throws[FileNotFoundException]
  private def readLines(): Seq[Seq[Int]] =
    io.Source
      .fromResource("year2024/day02.wsv")
      .getLines()
      .toSeq
      .map(_.split(" ").map(_.toInt).toSeq)

  def numSafeReports() = {
    readLines()
      .filter(row => row == row.sorted || row == row.sorted(Ordering.Int.reverse))
      .map(_.sorted)
      .count(row => row.sliding(2).map(a => (a(0) - a(1)).abs).forall(x => x >= 1 && x <= 3))
  }

  @main def run(): Unit = {
    println(s"Day 2 Part 1: ${numSafeReports()}")
  }

}
