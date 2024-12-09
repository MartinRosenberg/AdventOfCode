package com.martinbrosenberg.adventofcode
package year2024.day01

class HistorianHysteria_Spec extends BaseSpec {

  "Part 1" in {
    assertResult(11)(HistorianHysteria.totalDistance())
  }

  "Part 2" in {
    assertResult(31)(HistorianHysteria.totalSimilarityScore())
  }

}
