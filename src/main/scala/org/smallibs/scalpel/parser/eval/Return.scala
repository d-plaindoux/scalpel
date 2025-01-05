package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.{Parsec, Parser}
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.success

object Return:
  trait Api extends Parser:
    def returns[A](value: A): parsec.T[A] = s =>
      success(value, s, false)
