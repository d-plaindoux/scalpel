package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response, control}

import scala.annotation.targetName

trait Or extends Parser:

  def or[A, B](lhd: parsec.T[A], rhd: parsec.T[B]): parsec.T[Either[A, B]] = s =>
    lhd(s).fold(
      (a, s, b) => success(Left(a), s, b),
      (r, _, b) => rhd(s).fold(
        (a, s, b) => success(Right(a), s, b),
        (r, s, b) => failure(r, s, b)
      )
    )

trait OrInfix extends Or with control.MapInfix:
  extension [A](lhd: parsec.T[A])
    @targetName("or parsec")
    def <|>[B](rhd: parsec.T[B]): parsec.T[Either[A, B]] = or(lhd, rhd)

    @targetName("homogeneous or parsec")
    def <||>(rhd: parsec.T[A]): parsec.T[A] = lhd <|> rhd <&> {
      case Left(e) => e
      case Right(e) => e
    }
