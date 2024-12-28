package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.{FromList, FromString, Source}

trait Parsec:
  type E
  type S
  type T = [A] =>> S => Response[A, S]

  val source: Source {
    type E = Parsec.this.E
    type S = Parsec.this.S
  }

object Parsec:
  def fromString() =
    new Parsec {
      type E = Char
      type S = String
      val source = FromString()
    }

  def fromList[A]() =
    new Parsec {
      type S = List[A]
      type E = A
      val source = FromList[A]()
    }
