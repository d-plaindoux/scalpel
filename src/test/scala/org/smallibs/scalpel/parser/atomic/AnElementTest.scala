package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class AnElementTest extends AnyFunSuiteLike with AnElement.Api {
  type E = Int
  type S = List[Int]
  val parsec = Parsec.fromList

  test("Should retrieve one element") {
    assertResult(Response.success(1, List(2, 3), true))(element(1)(List(1, 2, 3)))
  }

  test("Should not retrieve one element") {
    assertResult(Response.failure(None, List(1, 2, 3), false))(element(2)(List(1, 2, 3)))
  }

}
