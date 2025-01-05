package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.response.Response

class NumbersTest extends AnyFunSuiteLike with Numbers.Api {
  type S = String
  val parsec = Parsec.fromString

  test("Should retrieve one natural") {
    assertResult(Response.success(42, "c", true))(natural("42c"))
  }

  test("Should retrieve one integer") {
    assertResult(Response.success(-42, "c", true))(integer("-42c"))
  }

  test("Should retrieve one rational") {
    assertResult(Response.success(-42.32, "c", true))(double("-42.32c"))
  }

  test("Should retrieve one double") {
    assertResult(Response.success(-42.32e-42, "c", true))(double("-42.32e-42c"))
  }

}
