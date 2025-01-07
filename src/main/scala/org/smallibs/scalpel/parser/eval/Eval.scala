package org.smallibs.scalpel.parser.eval

trait Eval
  extends Fail.Api with Fix.Api with Lookahead.Api with Return.Api with Satisfy.Api with Try.Api
