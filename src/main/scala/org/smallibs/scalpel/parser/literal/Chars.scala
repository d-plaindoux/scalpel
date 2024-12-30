package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.atomic.AnyElement
import org.smallibs.scalpel.parser.eval.Satisfy

object Chars:
  trait Api extends Parser:
    type E = Char

    private lazy val api = new AnyElement.Api with Satisfy.Api:
      type E = Char
      type S = Api.this.parsec.S

      val parsec = Api.this.parsec

    def char(e: Char): parsec.T[Char] =
      api.satisfy(api.any, _ == e)

    def charIn(e: List[Char]): parsec.T[Char] =
      api.satisfy(api.any, e.contains)

    def charIn(e: String): parsec.T[Char] =
      api.satisfy(api.any, e.contains)
