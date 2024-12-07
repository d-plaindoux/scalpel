package org.smallibs.scalpel.parser

import org.smallibs.scalpel.source.Source

type Parsec[E, A] = Source[E] => Response[A, Source[E]]

