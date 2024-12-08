

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parsec, Response}

trait AnyElement:
  val parsec: Parsec

  def any: parsec.T[parsec.source.E] = s =>
    parsec.source.next(s) match
      case (None, s) => failure(None, s, false)
      case (Some(a), s) => success(a, s, true)
