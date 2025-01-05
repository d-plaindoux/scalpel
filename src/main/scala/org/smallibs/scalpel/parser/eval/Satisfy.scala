package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.{failure, success}

import scala.annotation.targetName

object Satisfy:
  trait Api extends Parser:
    def satisfy[A](p: parsec.T[A], f: A => Boolean): parsec.T[A] = s =>
      p(s).fold(
        (a, ns, b) => if f(a) then success(a, ns, b) else failure(None, s, false),
        (r, s, b) => failure(r, s, b)
      )

  trait Infix extends Api:
    extension [A](p: parsec.T[A])
      @targetName("Satisfy parsec")
      def ?>(f: A => Boolean): parsec.T[A] =
        satisfy(p, f)
