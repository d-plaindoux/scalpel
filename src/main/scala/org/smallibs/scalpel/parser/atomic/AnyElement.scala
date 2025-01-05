

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.response.Response
import org.smallibs.scalpel.response.Response.{failure, success}

object AnyElement:
  trait Api extends Parser:
    def any: parsec.T[E] = s =>
      parsec.source.next(s) match
        case (None, s) => failure(None, s, false)
        case (Some(a), s) => success(a, s, true)
