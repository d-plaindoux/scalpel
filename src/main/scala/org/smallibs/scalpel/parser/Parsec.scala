package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.Source

trait Parsec:
  type S
  type T[A] = S => Response[A, S]

  val source: Source {type S = Parsec.this.S}