package org.smallibs.scalpel.source

class FromString extends Source:
  type E = Char
  type S = String

  override def next(s: String) =
    s match
      case s if s.nonEmpty => (Some(s.charAt(0)), s.substring(1))
      case s => (None, s)
