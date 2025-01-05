package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.{Parsec, Parser}
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.failure

object Fail:
  trait Api extends Parser:
    def fail[A](reason: Option[String] = None): parsec.T[A] = s =>
      failure(reason, s, false)