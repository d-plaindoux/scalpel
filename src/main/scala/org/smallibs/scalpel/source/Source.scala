package org.smallibs.scalpel.source

trait Source:
  type E
  type T

  val next: T => (Option[E], T)
