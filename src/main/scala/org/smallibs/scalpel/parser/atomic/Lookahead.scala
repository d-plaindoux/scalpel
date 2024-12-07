package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

trait Lookahead:
  def lookahead[E, A](p: Parsec[E, A]): Parsec[E, A] = s =>
    p(s) match
      case Failure(s, _) => Failure(s, false)
      case Success(a, _, _) => Success(a, s, false)
