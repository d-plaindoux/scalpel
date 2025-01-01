package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class AnyElementTest extends AnyFunSuiteLike with AnyElement.Api {
  type E = Int
  type S = List[Int]
  val parsec = Parsec.fromList

  test("Should retrieve one element") {
    assertResult(Response.success(1, List(2, 3), true))(any(List(1, 2, 3)))
  }

}
