package org.smallibs.scalpel.parser.flow

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.flow.Occurrence
import org.smallibs.scalpel.parser.literal.Chars
import org.smallibs.scalpel.response.Response

class OccurrenceTest extends AnyFunSuiteLike with Chars.Api with Occurrence.Infix {
  type S = List[Char]
  val parsec = Parsec.fromList[Char]

  test("Should retrieve one char from optional") {
    assertResult(Response.success(Some('1'), List('2', '3'), true))(char('1').?(List('1', '2', '3')))
  }

  test("Should not retrieve one char from optional") {
    assertResult(Response.success(None, List('1', '2', '3'), false))(char('2').?(List('1', '2', '3')))
  }

  test("Should retrieve some chars from optional and repeatable") {
    assertResult(Response.success(List('1', '2'), List('3'), true))(charIn('1', '2').*(List('1', '2', '3')))
  }

  test("Should retrieve no chars from optional and repeatable") {
    assertResult(Response.success(List(), List('1', '2', '3'), false))(charIn('2', '3').*(List('1', '2', '3')))
  }

  test("Should retrieve some chars from repeatable") {
    assertResult(Response.success(List('1', '2'), List('3'), true))(charIn('1', '2').+(List('1', '2', '3')))
  }

  test("Should not retrieve some chars from repeatable") {
    assertResult(Response.failure(None, List('1', '2', '3'), false))(charIn('2', '3').+(List('1', '2', '3')))
  }
}

