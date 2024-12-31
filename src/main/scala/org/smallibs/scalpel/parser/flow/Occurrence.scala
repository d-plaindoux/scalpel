package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.control.Map
import org.smallibs.scalpel.parser.eval.{Return, Try}
import org.smallibs.scalpel.parser.flow.Or

object Occurrence:
  trait Api extends Parser with Try.Api with Or.Infix with Return.Api with Map.Api:
    def opt[A](p: parsec.T[A]): parsec.T[Option[A]] =
      doTry(p) <&> (Some(_)) <||> returns(None)

    def optRep[A](p: parsec.T[A]): parsec.T[List[A]] = ???

    def rep[A](p: parsec.T[A]): parsec.T[List[A]] = ???