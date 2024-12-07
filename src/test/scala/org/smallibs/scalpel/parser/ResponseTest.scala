package org.smallibs.scalpel.parser

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.Success

class ResponseTest extends AnyFunSuiteLike {

  test("") {
    assertResult(1)(Success(1, (), true).fold((a: Int, s: Unit, b: Boolean) => 1)((s: Unit, b: Boolean) => 2))
  }

}
