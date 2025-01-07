package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.control.Map
import org.smallibs.scalpel.parser.eval.Fail
import org.smallibs.scalpel.parser.flow.{And, Flow}

object Strings:
  trait Api extends Parser with Fail.Api with Chars.Api with Flow.Api with Map.Infix with And.Infix:
    def string(s: String): parsec.T[String] =
      if s.isEmpty
      then fail(Some("Empty string"))
      else seq(s.toList.map(char)) <&> (_.mkString)

    def strings(s: String*): parsec.T[String] =
      choices(s.toList.map(string))