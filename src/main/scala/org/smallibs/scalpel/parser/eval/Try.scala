package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response}

object Try:
  trait Api extends Parser:
    def doTry[A](p: parsec.T[A]): parsec.T[A] = s =>
      p(s).fold((a, s, b) => success(a, s, b), (r, s, _) => failure(r, s, false))
