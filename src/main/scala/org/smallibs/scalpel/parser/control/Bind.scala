package org.smallibs.scalpel.parser.control

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response}

import scala.annotation.targetName

object Bind:
  trait Api extends Parser:
    def bind[A, B](ma: parsec.T[A])(f: A => parsec.T[B]): parsec.T[B] = s =>
      ma(s).fold(
        (a, s, b1) => f(a)(s).fold(
          (a, s, b2) => success(a, s, b1 || b2),
          (r, s, b2) => failure(r, s, b1 || b2)
        ),
        (r, s, b) => failure(r, s, b)
      )

    def flatMap[A, B](ma: parsec.T[A])(f: A => parsec.T[B]): parsec.T[B] =
      bind(ma)(f)

  trait Infix extends Api:
    extension [A](ma: parsec.T[A])
      @targetName("flatMap_infix")
      def >>=[B](f: A => parsec.T[B]): parsec.T[B] = flatMap(ma)(f)

    extension [A, B](f: A => parsec.T[B])
      @targetName("reverse_flatMap_infix")
      def =<<(ma: parsec.T[A]): parsec.T[B] = flatMap(ma)(f)