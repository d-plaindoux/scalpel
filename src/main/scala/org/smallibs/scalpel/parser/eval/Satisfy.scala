package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}


trait Satisfy:
  val parsec: Parsec

  def satisfy[A](p: parsec.T[A])(f: A => Boolean): parsec.T[A] = s =>
    p(s) match
      case Failure(s, b) => Failure(s, b)
      case Success(a, ns, b) =>
        if f(a) then
          Success(a, ns, b)
        else
          Failure(s, b)
