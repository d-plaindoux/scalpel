package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Response}

trait Lookahead:
  val parsec: Parsec

  def lookahead[A](p: parsec.T[A]): parsec.T[A] = s =>
    p(s).fold(
      (a, _, _) => success(a, s, false),
      (r, _, _) => failure(r, s, false)
    )
