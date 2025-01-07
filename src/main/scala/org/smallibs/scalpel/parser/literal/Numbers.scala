package org.smallibs.scalpel.parser.literal

import org.smallibs.scalpel.parser.Parser
import org.smallibs.scalpel.parser.control.Map
import org.smallibs.scalpel.parser.flow.Flow

object Numbers:
  trait Api extends Parser with Chars.Api with Flow.Infix with Map.Infix:
    def natural: parsec.T[Int] =
      Str.natural <&> (e => e.toInt)

    def integer: parsec.T[Int] =
      Str.integer <&> (e => e.toInt)

    def double: parsec.T[Double] =
      Str.double <&> (e => e.toDouble)

    private object Str:
      def natural: parsec.T[String] =
        rep(digit) <&> (e => e.mkString)

      private def sign: parsec.T[String] =
        (charIn('+', '-') <||> returns('+')) <&> (_.toString)

      def integer: parsec.T[String] =
        sign <~> natural <&> ((s, e) => s + e)

      private def decimal: parsec.T[String] =
        opt(char('.') <~> natural <&> (e => e._1 + e._2)) <&> (_.getOrElse(""))

      private def exponent: parsec.T[String] =
        opt(charIn('e', 'E') <~> integer <&> (e => e._1 + e._2)) <&> (_.getOrElse(""))

      def double: parsec.T[String] =
        integer <~> decimal <~> exponent <&> {
          case ((i, d), e) => i + d + e
        }
