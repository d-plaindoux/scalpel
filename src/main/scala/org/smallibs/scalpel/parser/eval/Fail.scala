package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.failure
import org.smallibs.scalpel.parser.{Parsec, Parser, Response}

trait Fail extends Parser:
  def fail[A](reason: Option[String] = None): parsec.T[A] = s =>
    failure(reason, s, false)
