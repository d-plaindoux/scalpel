package org.smallibs.scalpel.source

import org.scalatest.funsuite.AnyFunSuiteLike

class FromListTest extends AnyFunSuiteLike {

  test("An empty stream list produces nothing") {
    val s = FromList[Int]()

    assertResult((None, List()))(s.next(List()))
  }

  test("An a single stream list produces a result") {
    val s = FromList[Int]()

    assertResult((Some(1), List()))(s.next(List(1)))
  }

  test("An a stream list produces a result") {
    val s = FromList[Int]()

    assertResult((Some(1), List(2, 3)))(s.next(List(1, 2, 3)))
  }

}
