package com.github.speisz.euler.p063

import com.github.speisz.euler.util.naturalNumbers
import com.github.speisz.euler.util.pow
import com.github.speisz.euler.util.root
import com.github.speisz.euler.util.roundUp
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    @Test
    fun solution() {
        val sumOfPowersWithExponentEqualToNumberOfDigits = naturalNumbers()
            .takeWhile(::hasPowerWithNDigits)
            .sumOf(::countXWhereXPowNHasNDigits)

        assertThat(sumOfPowersWithExponentEqualToNumberOfDigits).isEqualTo(49)
    }

    private fun hasPowerWithNDigits(n: Int) = 9.pow(n) > 10.pow(n - 1)

    private fun countXWhereXPowNHasNDigits(n: Int): Int = 10 - smallestBaseHavingPowerWithNDigits(n)

    @Suppress("unused")
    private fun countXWhereXPowNHasNDigitsLogging(n: Int): Int {
        val smallestBase = smallestBaseHavingPowerWithNDigits(n)
        (smallestBase..9).forEach { base ->
            println("$base^$n=${base.pow(n)}")
        }
        return 10 - smallestBase
    }

    private fun smallestBaseHavingPowerWithNDigits(n: Int) = (10 / 10.root(n, precision = 3)).roundUp()
}
