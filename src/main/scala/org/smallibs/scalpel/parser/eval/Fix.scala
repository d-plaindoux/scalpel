package org.smallibs.scalpel.parser.eval

import org.smallibs.scalpel.parser.Parser

object Fix:
  trait Api extends Parser:
    def fix[A](f: parsec.T[A] => parsec.T[A]): parsec.T[A] = s =>
      f(fix(f))(s)
