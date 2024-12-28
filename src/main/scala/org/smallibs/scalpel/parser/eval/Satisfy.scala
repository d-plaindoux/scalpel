package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Parser, Response}

import scala.annotation.targetName


trait Satisfy extends Parser:
  def satisfy[A](p: parsec.T[A], f: A => Boolean): parsec.T[A] = s =>
    p(s).fold(
      (a, ns, b) => if f(a) then success(a, ns, b) else failure(None, s, false),
      (r, s, b) => failure(r, s, b)
    )

trait SatisfyInfix extends Satisfy:
  extension [A](p: parsec.T[A])
    @targetName("Satisfy parsec")
    def ?>(f: A => Boolean): parsec.T[A] =
      satisfy(p, f)
