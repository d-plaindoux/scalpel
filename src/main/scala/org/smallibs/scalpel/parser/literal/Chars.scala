package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.atomic.AnElement

object Chars:
  trait Api extends Parser:
    type E = Char

    private lazy val anElement = new AnElement.Api:
      type E = Char
      type S = Api.this.parsec.S

      val parsec = Api.this.parsec

    def char(e: Char): parsec.T[Char] =
      anElement.element(e)
