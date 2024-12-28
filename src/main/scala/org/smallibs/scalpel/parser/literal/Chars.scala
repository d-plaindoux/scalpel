package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.atomic.AnElement

trait Chars extends Parser:
  type E = Char

  val modules = new AnElement:
    type E = Char
    type S = Chars.this.parsec.S

    val parsec = Chars.this.parsec

  def element(e: Char): modules.parsec.T[Char] =
    modules.element(e)
