package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

trait Monad(val parsec: Parsec):
  def flatMap[A, B](f: A => parsec.T[B])(ma: parsec.T[A]): parsec.T[B] = s =>
    ma(s) match
      case Failure(s, b) => Failure(s, b)
      case Success(a, s, b1) =>
        f(a)(s) match
          case Failure(s, b2) => Failure(s, b1 || b2)
          case Success(a, s, b2) => Success(a, s, b1 || b2)
