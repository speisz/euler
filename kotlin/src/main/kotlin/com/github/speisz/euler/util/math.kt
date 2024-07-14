package com.github.speisz.euler.util

import kotlin.math.pow

fun naturalNumbers() = generateSequence(1, Int::inc)

fun <T> permutationsOf(items: List<T>): Sequence<List<T>> {
    if (items.size <= 1) return sequenceOf(items.toList())
    return items.asSequence()
        .flatMap { item -> permutationsOf(items - item).map { it + item } }
        .distinct()
}

fun <T> permutationsOf(vararg items: T): Sequence<List<T>> = permutationsOf(items.toList())

fun permutationsOf(number: Long): Sequence<Long> = permutationsOf(number.toString().toList())
    .map { chars -> String(chars.toCharArray()).toLong() }

fun permutationsOf(number: Int): Sequence<Int> = permutationsOf(number.toString().toList())
    .filterNot { it.first() == '0' }
    .map { chars -> String(chars.toCharArray()).toInt() }

fun permutationsOf2(number: Long): Sequence<Long> = permutationsOf(number.toDigitList())
    .filterNot { it.first() == ZERO }
    .map(List<Short>::toLong)

private fun List<Short>.toLong(): Long = mapIndexed { i, digit -> digit * 10L.pow(size - i - 1) }.sum()

fun Long.toDigitList(): List<Short> = (this / 10).let { remaining ->
    (if (remaining == 0L) listOf() else remaining.toDigitList()) + (this % 10).toShort()
}

fun Long.isPermutationOf(other: Long): Boolean {
    val digits = toDigitList()
    val otherDigits = other.toDigitList().toMutableList()
    return digits.all(otherDigits::remove) && otherDigits.isEmpty()
}

infix fun Long.pow(exponent: Int): Long = toDouble().pow(exponent).toLong()

infix fun Int.pow(exponent: Int): Long = toDouble().pow(exponent).toLong()

private const val ZERO = 0.toShort()
