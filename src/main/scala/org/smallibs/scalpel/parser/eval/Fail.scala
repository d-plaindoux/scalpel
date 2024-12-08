package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.failure
import org.smallibs.scalpel.parser.{Parsec, Response}

trait Fail:
  val parsec: Parsec

  def fail[A](reason: Option[String] = None): parsec.T[A] = s =>
    failure(reason, s, false)
