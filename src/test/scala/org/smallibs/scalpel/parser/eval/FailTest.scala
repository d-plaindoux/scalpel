package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.failure
import org.smallibs.scalpel.parser.{Parsec, Response}

class FailTest extends AnyFunSuiteLike with Fail.Api {
  type E = Char
  type S = String
  val parsec = Parsec.fromString

  test("Should fail without any reason") {
    assertResult(failure(None, "", false))(fail(None)(""))
  }

  test("Should fail with a reason") {
    assertResult(failure(Some("Boom"), "", false))(fail(Some("Boom"))(""))
  }
}