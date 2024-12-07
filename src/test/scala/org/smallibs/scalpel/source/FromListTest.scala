package org.smallibs.scalpel.source

import org.scalatest.funsuite.AnyFunSuiteLike

class FromListTest extends AnyFunSuiteLike {

  test("An empty stream list produces nothing") {
    val s = FromList[Int](List())

    assertResult((None, FromList[Int](List())))(s.next())
  }

  test("An a single stream list produces a result") {
    val s = FromList(List(1))

    assertResult((Some(1), FromList[Int](List())))(s.next())
  }

  test("An a stream list produces a result") {
    val s = FromList[Int](List(1, 2, 3))

    assertResult((Some(1), FromList[Int](List(2, 3))))(s.next())
  }

}
