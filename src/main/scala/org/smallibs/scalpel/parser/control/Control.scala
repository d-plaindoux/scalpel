package org.smallibs.scalpel.parser.control

object Control:
  trait Api
    extends Bind.Api
      with Map.Api

  trait Infix
    extends Bind.Infix
      with Map.Infix

