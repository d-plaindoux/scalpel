package org.smallibs.scalpel.parser.atomic

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.Success
import org.smallibs.scalpel.source.{FromList, Source}

class AnyElementTest extends AnyFunSuiteLike {

  test("Should retrieve on element") {
    val anyElement = new AnyElement {}

    assertResult(Success(1, FromList(List(2,3)), true))(anyElement.any(FromList(List(1, 2, 3))))
  }

}
