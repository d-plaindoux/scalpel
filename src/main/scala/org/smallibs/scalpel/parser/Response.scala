package org.smallibs.scalpel.parser

enum Response[A, S]:
  private case Success(value: A, source: S, consumed: Boolean)
  private case Failure(reason: Option[String], source: S, consumed: Boolean)

  def fold[R](success: (A, S, Boolean) => R, failure: (Option[String], S, Boolean) => R): R =
    this match
      case Success(a, s, b) => success(a, s, b)
      case Failure(r, s, b) => failure(r, s, b)

object Response {
  def success[A, S](a: A, s: S, b: Boolean): Response[A, S] = Response.Success(a, s, b)

  def failure[A, S](r: Option[String], s: S, b: Boolean): Response[A, S] = Response.Failure(r, s, b)
}