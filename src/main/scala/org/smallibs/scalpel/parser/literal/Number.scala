package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.flow.Occurrence
import org.smallibs.scalpel.parser.control.Map

object Number:
  trait Api extends Parser with Chars.Api with Occurrence.Api with Map.Infix:
    def natural: parsec.T[Int] =
      r
      ep(digit) <&> (e => e.mkString.toInt)



