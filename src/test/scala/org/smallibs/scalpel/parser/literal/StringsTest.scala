package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class StringsTest extends AnyFunSuiteLike with Strings.Api {
  type S = String
  val parsec = Parsec.fromString

  test("Should retrieve string [42]") {
    assertResult(Response.success("42", "c", true))(string("42")("42c"))
  }

  test("Should not retrieve an empty string") {
    assertResult(Response.failure(Some("Empty string"), "42c", false))(string("")("42c"))
  }

}
