package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.{Parser, control}
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.{failure, success}

import scala.annotation.targetName

object Or:
  trait Api extends Parser:

    def or[A, B](lhd: parsec.T[A], rhd: parsec.T[B]): parsec.T[Either[A, B]] = s =>
      lhd(s).fold(
        (a, s, b) => success(Left(a), s, b),
        (r, _, b) => rhd(s).fold(
          (a, s, b) => success(Right(a), s, b),
          (r, s, b) => failure(r, s, b)
        )
      )

    def choices[A](l: List[parsec.T[A]]): parsec.T[A] = s =>
      l match
        case Nil => failure(None, s, false)
        case h :: t =>
          h(s).fold(
            (a, s, b) => success(a, s, b),
            (r, ns, b) =>
              if b
              then failure(r, ns, b)
              else choices(t)(s)
          )

  trait Infix extends Api with control.Map.Infix:
    extension [A](lhd: parsec.T[A])
      @targetName("or_infix")
      def <|>[B](rhd: parsec.T[B]): parsec.T[Either[A, B]] = or(lhd, rhd)

      @targetName("or_infix_native")
      def <||>[B](rhd: parsec.T[B]): parsec.T[A | B] = lhd <|> rhd <&> {
        case Left(e) => e
        case Right(e) => e
      }
