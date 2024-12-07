package org.smallibs.scalpel.source

trait Source[E]:

  def next(): (Option[E], Source[E])