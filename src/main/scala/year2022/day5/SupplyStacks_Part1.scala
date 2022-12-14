package com.martinbrosenberg.adventofcode
package year2022.day5

import year2022.UsingLines

import scala.collection.mutable
import scala.io.Source
import scala.util.Using

object SupplyStacks_Part1 extends App {
  Using(Source.fromResource("year2022/day5/input")) { resource =>
    val lines = resource.getLines()
    val (stacksLines, movesLines) = lines.span(_.nonEmpty)

    val stacksRows = stacksLines.toVector.init.map(_.zipWithIndex.collect { case (c, i) if i % 4 == 1 => c })
    val nStacks = stacksRows.map(_.length).max
    val stacks = stacksRows.map(_.padTo(nStacks, ' ')).transpose.map(_.to(mutable.Stack).filterNot(_ == ' '))

    val pattern = """move (\d+) from (\d+) to (\d+)""".r
    movesLines.toVector.view.tail.map { case pattern(nMoves, a, b) =>
      (1 to nMoves.toInt, a.toInt - 1, b.toInt - 1)
    }.foreach { case (range, a, b) =>
      range.foreach(_ => stacks(b).push(stacks(a).pop()))
    }

    stacks.map(_.head).mkString
  }.foreach(println)
}
