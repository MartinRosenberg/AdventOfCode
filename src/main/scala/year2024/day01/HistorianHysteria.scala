package com.martinbrosenberg.adventofcode
package year2024.day01

object HistorianHysteria {

  private def readLines(): Seq[String] =
    io.Source.fromResource("year2024/day01.wsv").getLines().toSeq

  /** Part 1 */
  def totalDistance(): Int = {
    val (left, right) = readLines().map { case s"$a   $b" => (a.toInt, b.toInt) }.unzip
    left.sorted.zip(right.sorted).map(_ - _).map(math.abs).sum
  }

  /** Part 2 */
  def totalSimilarityScore() = {
    val (left, right) = readLines().map { case s"$a   $b" => (a.toInt, b.toInt) }.unzip
    left.map(a => a * right.count(_ == a)).sum
  }

  @main def run(): Unit = {
    println(s"Day 1 Part 1: ${totalDistance()}")
    println(s"Day 1 Part 2: ${totalSimilarityScore()}")
  }
}
