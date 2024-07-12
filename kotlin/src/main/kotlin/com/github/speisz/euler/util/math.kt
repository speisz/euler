package com.github.speisz.euler.util

import kotlin.math.pow

fun naturalNumbers() = generateSequence(1, Int::inc)

fun <T> permutationsOf(items: List<T>): Sequence<List<T>> {
    if (items.size <= 1) return sequenceOf(items.toList())
    return items.asSequence().flatMap { item ->
        permutationsOf(items - item)
            .map { it + item }
    }
}

fun <T> permutationsOf(vararg items: T): Sequence<List<T>> = permutationsOf(items.toList())

fun permutationsOf(number: Long): Sequence<Long> = permutationsOf(number.toString().toList())
    .map { chars -> String(chars.toCharArray()).toLong() }

fun permutationsOf2(number: Long): Sequence<Long> = permutationsOf(number.toDigitList())
    .map(List<Short>::toLong)

private fun List<Short>.toLong(): Long = mapIndexed { i, digit -> digit * 10L.pow(size - i - 1) }.sum()

fun Long.toDigitList(): List<Short> = (this / 10).let { remaining ->
    (if (remaining == 0L) listOf() else remaining.toDigitList()) + (this % 10).toShort()
}

infix fun Long.pow(exponent: Int): Long = toDouble().pow(exponent).toLong()
