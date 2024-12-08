package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Response.success
import org.smallibs.scalpel.parser.{Parsec, Response}

trait Return:
  val parsec: Parsec

  def returns[A](value: A): parsec.T[A] = s =>
    success(value, s, false)
