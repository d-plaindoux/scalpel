package org.smallibs.scalpel.parser.flow

import org.smallibs.scalpel.parser.Response.{failure, success}
import org.smallibs.scalpel.parser.{Parser, Response, control}

import scala.annotation.targetName

object And:
  trait Api extends Parser:
    def and[A, B](lhd: parsec.T[A], rhd: parsec.T[B]): parsec.T[(A, B)] = s =>
      lhd(s).fold(
        (a, s, b1) => rhd(s).fold(
          (b, s, b2) => success((a, b), s, b1 || b2),
          (r, s, b2) => failure(r, s, b1 || b2)
        ),
        (r, s, b) => failure(r, s, b)
      )

    def seq[A](l: List[parsec.T[A]]): parsec.T[List[A]] = s =>
      l match
        case Nil => success(Nil, s, false)
        case h::t =>
          h(s).fold(
            (a, s, b1) => seq(t)(s).fold(
              (l, s, b2) => success(a :: l, s, b1 || b2),
              (r, s, b2) => failure(r, s, b1 || b2)
            ),
            (r, s, b) => failure(r, s, b)
          )

  trait Infix extends Api with control.Map.Infix:
    extension [A](lhd: parsec.T[A])
      @targetName("and_infix")
      def <~>[B](rhd: parsec.T[B]): parsec.T[(A, B)] = and(lhd, rhd)

      @targetName("and_infix_right")
      def ~>[B](rhd: parsec.T[B]): parsec.T[B] = lhd <~> rhd <&> (_._2)

      @targetName("and_infix_left")
      def <~[B](rhd: parsec.T[B]): parsec.T[A] = lhd <~> rhd <&> (_._1)
