package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.{FromList, FromString, Source}

trait Parsec:
  type S
  type T[A] = S => Response[A, S]

  val source: Source {type S = Parsec.this.S}

object Parsec {
  def fromString(): Parsec {type S = String} =
    new Parsec {
      type S = String
      val source = FromString()
    }

  def fromList[A](): Parsec {type S = List[A]} =
    new Parsec {
      type S = List[A]
      val source = FromList[A]()
    }
}
