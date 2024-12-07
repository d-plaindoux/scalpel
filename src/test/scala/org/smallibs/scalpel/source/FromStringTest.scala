package org.smallibs.scalpel.source

import org.scalatest.funsuite.AnyFunSuiteLike

class FromStringTest extends AnyFunSuiteLike {

  test("An empty stream string produces nothing") {
    val s = FromString("")

    assertResult((None, s))(s.next())
  }

  test("An a single stream string produces a result") {
    val s = FromString("a")

    assertResult((Some('a'), FromString("")))(s.next())
  }

  test("An a stream string produces a result") {
    val s = FromString("abc")

    assertResult((Some('a'), FromString("bc")))(s.next())
  }

}
