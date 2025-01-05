package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Parser}

import scala.annotation.targetName

object Lookahead:
  trait Api extends Parser:
    def lookahead[A](p: parsec.T[A]): parsec.T[A] = s =>
      p(s).fold(
        (a, _, _) => success(a, s, false),
        (r, _, _) => failure(r, s, false)
      )
