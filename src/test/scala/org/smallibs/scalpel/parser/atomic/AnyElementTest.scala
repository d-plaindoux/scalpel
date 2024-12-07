package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.Success
import org.smallibs.scalpel.source.FromList

class AnyElementTest extends AnyFunSuiteLike {

  test("Should retrieve on element") {
    val anyElement = new AnyElement {
      override val parsec: Parsec {type S = List[Int]} = new Parsec {
        type S = List[Int]
        override val source: FromList[Int] = FromList[Int]()
      }
    }

    assertResult(Success(1, List(2, 3), true))(anyElement.any(List(1, 2, 3)))
  }

}
