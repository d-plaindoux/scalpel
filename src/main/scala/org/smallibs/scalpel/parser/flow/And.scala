package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Parser, Response}

import scala.annotation.targetName

trait And extends Parser:

  def and[A, B](lhd: parsec.T[A], rhd: parsec.T[B]): parsec.T[(A, B)] = s =>
    lhd(s).fold(
      (a, s, b1) => rhd(s).fold(
        (b, s, b2) => success((a, b), s, b1 || b2),
        (r, s, b2) => failure(r, s, b1 || b2)
      ),
      (r, s, b) => failure(r, s, b)
    )

  trait AndInfix:
    extension [A](lhd: parsec.T[A])
      @targetName("or parsec")
      def <+>[B](rhd: parsec.T[B]): parsec.T[(A, B)] = and(lhd, rhd)
