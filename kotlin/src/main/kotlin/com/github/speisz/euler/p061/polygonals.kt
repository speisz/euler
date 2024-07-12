package com.github.speisz.euler.p061

import com.github.speisz.euler.util.naturalNumbers

fun triangles(): Sequence<Int> = naturalNumbers()
    .map { n -> n * (n + 1) / 2 }
    .takeOnly4DigitNumbers()

fun squares(): Sequence<Int> = naturalNumbers()
    .map { n -> n * n }
    .takeOnly4DigitNumbers()

fun pentagonals(): Sequence<Int> = naturalNumbers()
    .map { n -> n * (3 * n - 1) / 2 }
    .takeOnly4DigitNumbers()

fun hexagonals(): Sequence<Int> = naturalNumbers()
    .map { n -> n * (2 * n - 1) }
    .takeOnly4DigitNumbers()

fun heptagonals(): Sequence<Int> = naturalNumbers()
    .map { n -> n * (5 * n - 3) / 2 }
    .takeOnly4DigitNumbers()

fun octagonals(): Sequence<Int> = naturalNumbers()
    .map { n -> n * (3 * n - 2) }
    .takeOnly4DigitNumbers()

fun Sequence<Int>.takeOnly4DigitNumbers() = filter { it >= 1_000 }.takeWhile { it < 10_000 }
