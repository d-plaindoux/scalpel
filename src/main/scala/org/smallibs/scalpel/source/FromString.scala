package org.smallibs.scalpel.source

case class FromString(val value: String) extends Source[Char]:
  override def next() =
    value match
      case s if s.nonEmpty => (Some(s.charAt(0)), FromString(s.substring(1)))
      case s => (None, this)
