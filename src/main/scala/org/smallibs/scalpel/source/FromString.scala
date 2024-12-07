package org.smallibs.scalpel.source

class FromString extends Source[String]:
  type E = Char

  override def next(s: String) =
    s match
      case s if s.nonEmpty => (Some(s.charAt(0)), s.substring(1))
      case s => (None, s)
