package com.martinbrosenberg.adventofcode
package year2024.day01

object HistorianHysteria {

  // TODO: genericize this
  private def readLines(): Seq[String] =
    io.Source.fromResource("year2024/day01.wsv").getLines().toSeq

  // TODO: named tuples upcoming in Scala 3.6.2
  private def columns: (Seq[Int], Seq[Int]) =
    readLines().map { case s"$a   $b" => (a.toInt, b.toInt) }.unzip

  /** Part 1 */
  def totalDistance(): Int = {
    val (left, right) = columns
    left.sorted.zip(right.sorted).map(_ - _).map(math.abs).sum
  }

  /** Part 2 */
  def totalSimilarityScore(): Int = {
    val (left, right) = columns
    left.map(a => a * right.count(_ == a)).sum
  }

  @main def run(): Unit = {
    println(s"Day 1 Part 1: ${totalDistance()}")
    println(s"Day 1 Part 2: ${totalSimilarityScore()}")
  }
}
