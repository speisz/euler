package com.github.speisz.euler.util

import java.math.BigInteger
import kotlin.math.pow

fun naturalNumbers(seed: Int = 1) = generateSequence(seed, Int::inc)

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

private fun List<Short>.toLong(): Long = mapIndexed { i, digit -> digit * 10L.powLong(size - i - 1) }.sum()

fun Long.toDigitList(): List<Short> = (this / 10).let { remaining ->
    (if (remaining == 0L) listOf() else remaining.toDigitList()) + (this % 10).toShort()
}

fun Long.isPermutationOf(other: Long): Boolean {
    val digits = toDigitList()
    val otherDigits = other.toDigitList().toMutableList()
    return digits.all(otherDigits::remove) && otherDigits.isEmpty()
}

fun Int.root(n: Int, precision: Int = 1): Float {
    var result = 0.0f
    (0..precision).map { decimalPoint ->
        result = naturalNumbers(seed = 0).map { (result + it.toFloat() / 10.powInt(decimalPoint)) }
            .takeWhile { it.pow(n) <= this }
            .last()
    }
    return result
}

infix fun Long.pow(exponent: Int): BigInteger = BigInteger.valueOf(this).pow(exponent)
infix fun Int.pow(exponent: Int): BigInteger = toLong().pow(exponent)
infix fun Long.powLong(exponent: Int): Long = toDouble().pow(exponent).toLong()
infix fun Int.powInt(exponent: Int): Long = toDouble().pow(exponent).toLong()

fun Float.roundUp(): Int = this.toInt().let { if (this - it == 0f) it else it + 1 }

private const val ZERO = 0.toShort()
