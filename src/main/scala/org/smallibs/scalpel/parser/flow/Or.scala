package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Parser, Response}

import scala.annotation.targetName

trait Or extends Parser:

  def or[A, B](lhd: parsec.T[A], rhd: parsec.T[B]): parsec.T[A | B] = s =>
    lhd(s).fold(
      (a, s, b) => success(a, s, b),
      (r, _, b) => rhd(s).fold(
        (a, s, b) => success(a, s, b),
        (r, s, b) => failure(r, s, b)
      )
    )

  trait OrInfix:
    extension [A](lhd: parsec.T[A])
      @targetName("or parsec")
      def <|>[B](rhd: parsec.T[B]): parsec.T[A | B] = or(lhd, rhd)
