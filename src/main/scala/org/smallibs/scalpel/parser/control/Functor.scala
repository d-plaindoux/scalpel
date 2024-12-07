package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

import scala.annotation.targetName

trait Functor:
  def map[E, A, B](f: A => B)(ma: Parsec[E, A]): Parsec[E, B] = s =>
    ma(s) match
      case Failure(s, b) => Failure(s, b)
      case Success(a, s, b) => Success(f(a), s, b)

  extension [E, A](ma: Parsec[E, A])
    @targetName("reverse map")
    def <&>[B](f: A => B): Parsec[E, B] = map(f)(ma)
