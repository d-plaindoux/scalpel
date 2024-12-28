package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.success
import org.smallibs.scalpel.parser.{Parsec, Parser, Response}

trait Return extends Parser:
  def returns[A](value: A): parsec.T[A] = s =>
    success(value, s, false)
