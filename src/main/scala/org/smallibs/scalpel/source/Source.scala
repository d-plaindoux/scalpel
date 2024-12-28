package org.smallibs.scalpel.source

trait Source:
  type E
  type S
  
  def next(s: S): (Option[E], S)
