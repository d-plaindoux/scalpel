package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.success
import org.smallibs.scalpel.parser.{Parsec, Response}

class ReturnTest extends AnyFunSuiteLike {

  test("Should success with a given value") {
    val api = new Return.Api {
      type E = Char
      type S = String
      val parsec = Parsec.fromString()
    }

    assertResult(success(1, "", false))(api.returns(1)(""))
  }
}