package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.failure
import org.smallibs.scalpel.parser.{Parsec, Response}

class FailTest extends AnyFunSuiteLike {

  test("Should fail without any reason") {
    val api = new Fail.Api {
      type E = Char
      type S = String

      val parsec = Parsec.fromString
    }

    assertResult(failure(None, "", false))(api.fail()(""))
  }

  test("Should fail with a reason") {
    val api = new Fail.Api {
      type E = Char
      type S = String

      val parsec = Parsec.fromString
    }

    assertResult(failure(Some("Boom"), "", false))(api.fail(Some("Boom"))(""))
  }
}