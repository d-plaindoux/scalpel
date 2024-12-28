

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.eval.Satisfy

import scala.language.postfixOps

trait AnElement extends Parser:
  val modules = new AnyElement with Satisfy:
    type E = AnElement.this.E
    type S = AnElement.this.S

    val parsec = AnElement.this.parsec

  def element(e: E): modules.parsec.T[E] =
    modules.satisfy(modules.any, (a => a == e))