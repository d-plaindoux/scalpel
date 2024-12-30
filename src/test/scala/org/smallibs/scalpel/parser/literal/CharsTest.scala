package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class CharsTest extends AnyFunSuiteLike {

  private def givenCharsParser =
    new Chars.Api:
      type S = List[Char]
      val parsec = Parsec.fromList[Char]()

  // TESTS

  test("Should retrieve one char") {
    val api = givenCharsParser

    assertResult(Response.success('1', List('2', '3'), true))(api.char('1')(List('1', '2', '3')))
  }

  test("Should not retrieve one char") {
    val api = givenCharsParser

    assertResult(Response.failure(None, List('1', '2', '3'), false))(api.char('2')(List('1', '2', '3')))
  }

  test("Should retrieve one char from a list") {
    val api = givenCharsParser

    assertResult(Response.success('1', List('2', '3'), true))(api.charIn(List('1'))(List('1', '2', '3')))
  }

  test("Should not retrieve one char from a list") {
    val api = givenCharsParser

    assertResult(Response.failure(None, List('1', '2', '3'), false))(api.charIn(List('2'))(List('1', '2', '3')))
  }

  test("Should retrieve one char from a string") {
    val api = givenCharsParser

    assertResult(Response.success('1', List('2', '3'), true))(api.charIn("1")(List('1', '2', '3')))
  }

  test("Should not retrieve one char from a string") {
    val api = givenCharsParser

    assertResult(Response.failure(None, List('1', '2', '3'), false))(api.charIn("2")(List('1', '2', '3')))
  }

}
