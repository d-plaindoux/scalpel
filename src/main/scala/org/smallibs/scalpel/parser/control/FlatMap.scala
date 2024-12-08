package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Response}

trait FlatMap:
  val parsec: Parsec

  def flatMap[A, B](f: A => parsec.T[B])(ma: parsec.T[A]): parsec.T[B] = s =>
    ma(s).fold(
      (a, s, b1) => f(a)(s).fold(
        (a, s, b2) => success(a, s, b1 || b2),
        (r, s, b2) => failure(r, s, b1 || b2)
      ),
      (r, s, b) => failure(r, s, b)
    )
