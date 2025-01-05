package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.{failure, success}

object Try:
  trait Api extends Parser:
    def doTry[A](p: parsec.T[A]): parsec.T[A] = s =>
      p(s).fold((a, s, b) => success(a, s, b), (r, s, _) => failure(r, s, false))
