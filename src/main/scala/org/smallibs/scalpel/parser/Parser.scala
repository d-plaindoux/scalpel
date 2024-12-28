package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.{FromList, FromString, Source}

trait Parser:
  type E
  type S

  val parsec: Parsec {
    type E = Parser.this.E
    type S = Parser.this.S
  }
