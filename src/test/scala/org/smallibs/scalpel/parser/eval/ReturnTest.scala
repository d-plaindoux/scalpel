package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.success


class ReturnTest extends AnyFunSuiteLike with Return.Api {
  type E = Char
  type S = String
  val parsec = Parsec.fromString

  test("Should success with a given value") {
    assertResult(success(1, "", false))(returns(1)(""))
  }
}