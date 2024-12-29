package org.smallibs.scalpel.parser.flow

object Flow:
  trait Api extends Or.Api with And.Api

  trait Infix extends Or.Infix with And.Infix