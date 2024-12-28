

package org.smallibs.scalpel.parser.atomic

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.eval.SatisfyInfix

import scala.language.postfixOps

trait AnElement extends Parser with AnyElement with SatisfyInfix:
  def element(e: E): parsec.T[E] =
    any ?> (a => a == e)