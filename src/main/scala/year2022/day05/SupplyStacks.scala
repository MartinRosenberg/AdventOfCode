package com.martinbrosenberg.adventofcode
package year2022.day05

import scala.collection.mutable
import scala.io.Source
import scala.util.Using

object SupplyStacks extends App {
  val lines = Using.resource(Source.fromResource("year2022/day05/input"))(_.getLines().toVector)
  val (stackLines, moveLines) = lines.span(_.nonEmpty)

  val stackRows = stackLines.init.map(_
    .zipWithIndex
    .collect { case (c, i) if i % 4 == 1 => c }
  )
  val nStacks = stackRows.map(_.length).max
  val stacksImmutable = stackRows
    .map(_.padTo(nStacks, ' '))
    .transpose
    .map(_.filter(_.isUpper))

  val pattern = """move (\d+) from (\d+) to (\d+)""".r
  val moves = moveLines.tail.map { case pattern(nMoves, a, b) =>
    (1 to nMoves.toInt, a.toInt - 1, b.toInt - 1)
  }

  val part1 = {
    val stacks = stacksImmutable.map(_.to(mutable.Stack))

    moves.foreach { case (range, a, b) =>
      range.foreach(_ => stacks(b).push(stacks(a).pop()))
    }

    stacks.map(_.head).mkString
  }
  println(s"Part 1: $part1")

  val part2 = {
    val stacks = stacksImmutable.map(_.to(mutable.Stack))
    val tempStack = mutable.Stack.empty[Char]

    moves.foreach { case (range, a, b) =>
      range.foreach(_ => tempStack.push(stacks(a).pop()))
      range.foreach(_ => stacks(b).push(tempStack.pop()))
    }

    stacks.map(_.head).mkString
  }
  println(s"Part 2: $part2")
}
