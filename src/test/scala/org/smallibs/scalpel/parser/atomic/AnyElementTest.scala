package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class AnyElementTest extends AnyFunSuiteLike {

  test("Should retrieve one element") {
    val api = new AnyElement.Api {
      type E = Int
      type S = List[Int]

      val parsec = Parsec.fromList
    }

    assertResult(Response.success(1, List(2, 3), true))(api.any(List(1, 2, 3)))
  }

}
