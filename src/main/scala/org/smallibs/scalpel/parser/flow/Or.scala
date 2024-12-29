package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response, control}

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

  trait Infix extends Api with control.Map.Infix:
    extension [A](lhd: parsec.T[A])
      @targetName("or_infix")
      def <|>[B](rhd: parsec.T[B]): parsec.T[Either[A, B]] = or(lhd, rhd)

      @targetName("or_infix_native")
      def <||>[B](rhd: parsec.T[B]): parsec.T[A | B] = lhd <|> rhd <&> {
        case Left(e) => e
        case Right(e) => e
      }
