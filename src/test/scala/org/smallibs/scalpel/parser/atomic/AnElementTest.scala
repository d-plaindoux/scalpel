package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class AnElementTest extends AnyFunSuiteLike {

  test("Should retrieve one element") {
    val api = new AnElement {
      type E = Int
      type S = List[Int]

      val parsec = Parsec.fromList[Int]()
    }

    assertResult(Response.success(1, List(2, 3), true))(api.element(1)(List(1, 2, 3)))
  }

  test("Should not retrieve one element") {
    val api = new AnElement {
      type E = Int
      type S = List[Int]

      val parsec = Parsec.fromList[Int]()
    }

    assertResult(Response.failure(None, List(1, 2, 3), false))(api.element(2)(List(1, 2, 3)))
  }

}
