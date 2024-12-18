package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Response}


trait Satisfy:
  val parsec: Parsec

  def satisfy[A](p: parsec.T[A])(f: A => Boolean): parsec.T[A] = s =>
    p(s).fold(
      (a, ns, b) => if f(a) then success(a, ns, b) else failure(None, s, false),
      (r, s, b) => failure(r, s, b)
    )
