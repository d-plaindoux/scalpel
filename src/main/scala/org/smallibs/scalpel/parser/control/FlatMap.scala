package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response}

import scala.annotation.targetName

object FlatMap:
  trait Api extends Parser:
    def flatMap[A, B](ma: parsec.T[A])(f: A => parsec.T[B]): parsec.T[B] = s =>
      ma(s).fold(
        (a, s, b1) => f(a)(s).fold(
          (a, s, b2) => success(a, s, b1 || b2),
          (r, s, b2) => failure(r, s, b1 || b2)
        ),
        (r, s, b) => failure(r, s, b)
      )

  trait Infix extends Api:
    extension [A](ma: parsec.T[A])
      @targetName("flatMap_infix")
      def >>=[B](f: A => parsec.T[B]): parsec.T[B] = flatMap(ma)(f)