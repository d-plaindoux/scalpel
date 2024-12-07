package org.smallibs.scalpel.source

trait Source[S]:
  type E

  def next(s: S): (Option[E], S)
