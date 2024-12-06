package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

trait Functor(val parsec: Parsec):
  def map[A, B](f: A => B)(ma: parsec.T[A]): parsec.T[B] = s =>
    ma(s) match
      case Failure(s, b) => Failure(s, b)
      case Success(a, s, b) => Success(f(a), s, b)