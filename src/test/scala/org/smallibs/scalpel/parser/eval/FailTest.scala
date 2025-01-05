package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.failure

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