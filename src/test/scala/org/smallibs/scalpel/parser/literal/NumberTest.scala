package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class NumberTest extends AnyFunSuiteLike with Number.Api {
  type S = List[Char]
  val parsec = Parsec.fromList[Char]

  test("Should retrieve one number only") {
    assertResult(Response.success(42, List('c'), true))(natural(List('4', '2', 'c')))
  }

}
