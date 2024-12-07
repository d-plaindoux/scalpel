package org.smallibs.scalpel.source

class FromList[A] extends Source[List[A]]:
  type E = A

  override def next(s: List[A]) =
    s match
      case Nil => (None, s)
      case h :: tail => (Some(h), tail)
