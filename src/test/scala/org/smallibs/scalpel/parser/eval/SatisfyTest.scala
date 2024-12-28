package org.smallibs.scalpel.parser.eval

import org.scalatest.funsuite.AnyFunSuiteLike
import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{failure, success}

class SatisfyTest extends AnyFunSuiteLike {

  type Api = Satisfy & Return {type E = Unit; type S = List[Unit]}

  test("Should satisfy the condition") {
    val api: Api = new Satisfy with Return {
      type E = Unit
      type S = List[Unit]

      val parsec = Parsec.fromList()
    }

    assertResult(success('a', List(), false))(api.satisfy(api.returns('a'), a => a == 'a')(List()))
  }

  test("Should not satisfy the condition") {
    val api = new Satisfy with Return {
      type E = Unit
      type S = List[Unit]

      val parsec = Parsec.fromList()
    }

    assertResult(failure(None, List(), false))(api.satisfy(api.returns('b'), a => a == 'a')(List()))
  }
}
