package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.response.Response

class CharsTest extends AnyFunSuiteLike with Chars.Api {
  type S = List[Char]
  val parsec = Parsec.fromList[Char]

  test("Should retrieve one char") {
    assertResult(Response.success('1', List('2', '3'), true))(char('1')(List('1', '2', '3')))
  }

  test("Should not retrieve one char") {
    assertResult(Response.failure(None, List('1', '2', '3'), false))(char('2')(List('1', '2', '3')))
  }

  test("Should retrieve one char from a list") {
    assertResult(Response.success('1', List('2', '3'), true))(charIn('1')(List('1', '2', '3')))
  }

  test("Should not retrieve one char from a list") {
    assertResult(Response.failure(None, List('1', '2', '3'), false))(charIn('2')(List('1', '2', '3')))
  }

  test("Should retrieve one char from a string") {
    assertResult(Response.success('1', List('2', '3'), true))(charIn("1")(List('1', '2', '3')))
  }

  test("Should not retrieve one char from a string") {
    assertResult(Response.failure(None, List('1', '2', '3'), false))(charIn("2")(List('1', '2', '3')))
  }

  test("Should retrieve one alpha from a string") {
    assertResult(Response.success('a', List('2', '3'), true))(alpha(List('a', '2', '3')))
  }

  test("Should retrieve one ALPHA from a string") {
    assertResult(Response.success('C', List('2', '3'), true))(alpha(List('C', '2', '3')))
  }

  test("Should not retrieve one alpha from a string") {
    assertResult(Response.failure(None, List('1', '2', '3'), false))(alpha(List('1', '2', '3')))
  }

  test("Should retrieve one digit from a string") {
    assertResult(Response.success('1', List('2', '3'), true))(digit(List('1', '2', '3')))
  }

  test("Should not retrieve one digit from a string") {
    assertResult(Response.failure(None, List('a', '2', '3'), false))(digit(List('a', '2', '3')))
  }

}
