package com.martinbrosenberg.adventofcode

import scala.io.Source
import scala.util.{Try, Using}

package object year2022 {
  object UsingLines {
    def apply(uri: String): Try[Vector[String]] =
      Using(Source.fromResource(uri))(
        _.getLines()
          .map(_.trim)
          .filterNot(_.isBlank)
          .toVector
      )
  }
}
