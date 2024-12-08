package org.smallibs.scalpel.parser

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.success

class ResponseTest extends AnyFunSuiteLike {

  test("") {
    assertResult(1)(success(1, (), true).fold(
      (a, s, b) => 1,
      (r, s, b) => 2)
    )
  }

}
