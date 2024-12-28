package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.atomic.AnElement

trait Chars extends Parser:
  type E = Char

  private lazy val anElement = new AnElement:
    type E = Char
    type S = Chars.this.parsec.S

    val parsec = Chars.this.parsec

  def char(e: Char): parsec.T[Char] =
    anElement.element(e)
