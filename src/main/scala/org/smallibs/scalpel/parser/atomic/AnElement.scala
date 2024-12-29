

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.eval.Satisfy

import scala.language.postfixOps

object AnElement:
  trait Api extends Parser with AnyElement.Api with Satisfy.Infix:
    def element(e: E): parsec.T[E] =
      any ?> (a => a == e)