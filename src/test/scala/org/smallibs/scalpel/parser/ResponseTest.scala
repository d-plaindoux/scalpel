package org.smallibs.scalpel.parser

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.{failure, success}

class ResponseTest extends AnyFunSuiteLike {

  test("Should fold a success") {
    assertResult(1)(success(1, (), true).fold(
      (a, s, b) => 1,
      (r, s, b) => 2)
    )
  }

  test("Should fold a failure") {
    assertResult(2)(failure(None, (), true).fold(
      (a, s, b) => 1,
      (r, s, b) => 2)
    )
  }
}
