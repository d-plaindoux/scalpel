package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class AnyElementTest extends AnyFunSuiteLike {

  test("Should retrieve one element") {
    val api = new AnyElement {
      val parsec: Parsec {type S = List[Int]} = Parsec.fromList[Int]()
    }

    assertResult(Response.success(1, List(2, 3), true))(api.any(List(1, 2, 3)))
  }

}
