package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.Source

trait Parsec:
  type S
  val source: Source[S]
  type T[A] = S => Response[A, S]


