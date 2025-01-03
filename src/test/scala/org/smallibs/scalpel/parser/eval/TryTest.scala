package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.flow.Or
import org.smallibs.scalpel.parser.{Parsec, Response}

class TryTest extends AnyFunSuiteLike with Fail.Api with Return.Api with Or.Infix with Try.Api {
  type E = Char
  type S = String
  val parsec = Parsec.fromString


  test("Should return after successful try") {
    assertResult(success(1, "", false))(doTry(returns(1))(""))
  }

  test("Should return after unsuccessful try") {
    assertResult(success(1, "", false))((doTry(fail(None)) <||> returns(1))(""))
  }

}