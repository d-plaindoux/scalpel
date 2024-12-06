package org.smallibs.scalpel.parser

enum Response[A, S]:
  case Success(value: A, stream: S, consumed: Boolean)
  case Failure(stream: S, consumed: Boolean)
