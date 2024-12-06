package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parsec
import org.smallibs.scalpel.parser.Response.{Failure, Success}

trait Any(val parsec: Parsec):
  val any: parsec.T[parsec.source.E] = s =>
    parsec.source.next(s) match
      case (None, s) => Failure(s, false)
      case (Some(a), s) => Success(a, s, true)