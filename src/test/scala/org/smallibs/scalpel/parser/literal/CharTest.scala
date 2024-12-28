package org.smallibs.scalpel.parser.literal

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.{Parsec, Response}

class CharTest extends AnyFunSuiteLike {

  test("Should retrieve one char") {
    val api = new Chars {
      type S = List[Char]

      val parsec = Parsec.fromList[Char]()
    }

    assertResult(Response.success('1', List('2', '3'), true))(api.char('1')(List('1', '2', '3')))
  }

  test("Should not retrieve one char") {
    val api = new Chars {
      type S = List[Char]

      val parsec = Parsec.fromList[Char]()
    }

    assertResult(Response.failure(None, List('1', '2', '3'), false))(api.char('2')(List('1', '2', '3')))
  }
}
