package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}
import org.smallibs.scalpel.source.Source

trait AnyElement:
  def any[E]: Parsec[E, E] = s =>
    s.next() match
      case (None, s) => Failure(s, false)
      case (Some(a), s) => Success(a, s, true)