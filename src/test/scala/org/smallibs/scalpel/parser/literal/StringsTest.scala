package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class StringsTest extends AnyFunSuiteLike with Strings.Api {
  type S = String
  val parsec = Parsec.fromString

  test("Should retrieve the string [42]") {
    assertResult(Response.success("42", "c", true))(string("42")("42c"))
  }

  test("Should not retrieve an empty string") {
    assertResult(Response.failure(Some("Empty string"), "42c", false))(string("")("42c"))
  }

  test("Should retrieve a string") {
    assertResult(Response.success("42", "c", true))(strings("24", "42")("42c"))
  }

  test("Should not retrieve a string") {
    assertResult(Response.failure(None, "2c", true))(strings("41", "42")("42c"))
  }

}
