package org.smallibs.scalpel.parser.flow

object Flow:
  trait Api extends And.Api with Occurrence.Api with Or.Api

  trait Infix extends And.Infix with Occurrence.Infix with Or.Infix
