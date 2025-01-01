package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{failure, success}

class SatisfyTest extends AnyFunSuiteLike with Satisfy.Api with Return.Api {
  type E = Unit
  type S = List[Unit]
  val parsec = Parsec.fromList

  test("Should satisfy the condition") {
    assertResult(success('a', List(), false))(satisfy(returns('a'), a => a == 'a')(List()))
  }

  test("Should not satisfy the condition") {
    assertResult(failure(None, List(), false))(satisfy(returns('b'), a => a == 'a')(List()))
  }
}
