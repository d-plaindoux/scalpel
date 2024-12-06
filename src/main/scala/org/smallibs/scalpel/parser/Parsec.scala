package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.Source

trait Parsec:
  val source: Source

  type T = [A] =>> source.T => Response[A, source.T]
  