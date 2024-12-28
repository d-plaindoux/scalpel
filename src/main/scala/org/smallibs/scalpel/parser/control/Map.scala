package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response}

import scala.annotation.targetName

trait Map extends Parser:
  def map[A, B](f: A => B)(ma: parsec.T[A]): parsec.T[B] = s =>
    ma(s).fold(
      (a, s, b) => success(f(a), s, b),
      (r, s, b) => failure(r, s, b)
    )

trait MapInfix extends Map:
  extension [A](ma: parsec.T[A])
    @targetName("reverse map")
    def <&>[B](f: A => B): parsec.T[B] = map(f)(ma)
