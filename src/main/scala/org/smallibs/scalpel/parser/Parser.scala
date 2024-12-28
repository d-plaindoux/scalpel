package org.smallibs.scalpel.parser

trait Parser:
  type E
  type S

  val parsec: Parsec {
    type E = Parser.this.E
    type S = Parser.this.S
  }
