package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{Failure, Success}
import org.smallibs.scalpel.parser.control.{Bind, Map}
import org.smallibs.scalpel.parser.eval.{Return, Try}
import org.smallibs.scalpel.parser.flow.Or
import org.smallibs.scalpel.parser.{Parser, Response}

import scala.Tuple.FlatMap
import scala.annotation.{tailrec, targetName}

object Occurrence:
  trait Api extends Parser with Try.Api with Or.Infix with Return.Api with Map.Infix with Bind.Infix:
    def opt[A](p: parsec.T[A]): parsec.T[Option[A]] =
      doTry(p) <&> (Some(_)) <||> returns(None)

    def optRep[A](p: parsec.T[A]): parsec.T[List[A]] = s => {
      var result: List[A] = List()
      var consumed: Boolean = false
      var source: parsec.S = s
      var loop: Boolean = true

      while (loop) {
        p(source).fold(
          (e, s, b) => {
            result = e :: result
            source = s
            consumed = b || consumed
          },
          (r, s, b) => {
            loop = false
          }
        )
      }

      Response.success(result.reverse, source, consumed)
    }

    def rep[A](p: parsec.T[A]): parsec.T[List[A]] =
      p >>= (e => optRep(p) <&> (l => e :: l))

  trait Infix extends Api:
    extension [A](p: parsec.T[A])
      @targetName("opt_infix")
      def ? = opt(p)

      @targetName("optRep_infix")
      def * = optRep(p)

      @targetName("rep_infix")
      def + = rep(p)