

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

trait AnyElement:
  val parsec: Parsec

  def any: parsec.T[parsec.source.E] = s =>
    parsec.source.next(s) match
      case (None, s) => Failure(s, false)
      case (Some(a), s) => Success(a, s, true)
