package org.smallibs.scalpel.source

import org.scalatest.funsuite.AnyFunSuiteLike

class FromStringTest extends AnyFunSuiteLike {

  test("An empty stream string produces nothing") {
    val s = FromString()

    assertResult((None, ""))(s.next(""))
  }

  test("An a single stream string produces a result") {
    val s = FromString()

    assertResult((Some('a'), ""))(s.next("a"))
  }

  test("An a stream string produces a result") {
    val s = FromString()

    assertResult((Some('a'), "bc"))(s.next("abc"))
  }

}
