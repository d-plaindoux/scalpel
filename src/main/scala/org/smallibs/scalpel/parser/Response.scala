package org.smallibs.scalpel.parser

enum Response[A, S]:
  case Success(value: A, stream: S, consumed: Boolean)
  case Failure(stream: S, consumed: Boolean)

  def fold[R](success: (A, S, Boolean) => R)(failure: (S, Boolean) => R): R =
    this match
      case Success(a, s, b) => success(a, s, b)
      case Failure(s, b) => failure(s, b)
