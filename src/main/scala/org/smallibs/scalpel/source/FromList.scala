package org.smallibs.scalpel.source

case class FromList[A](value: List[A]) extends Source[A]:
  override def next() =
    value match
      case Nil => (None, this)
      case h :: tail => (Some(h), FromList(tail))
