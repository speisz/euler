package com.github.speisz.euler.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MathKtTest {

    @Nested
    inner class PermutationsOfCollections {
        @Test
        fun `generates permutations`() {
            assertThat(permutationsOf(1, 2, 3).toList()).containsExactlyInAnyOrder(
                listOf(1, 2, 3),
                listOf(1, 3, 2),
                listOf(2, 1, 3),
                listOf(2, 3, 1),
                listOf(3, 1, 2),
                listOf(3, 2, 1),
            )
        }

        @Test
        fun `prints permutations`() {
            permutationsOf(listOf(1, 1), listOf(2, 2), listOf(3, 3), listOf(4, 4))
                .forEach(::println)
        }
    }

    @Nested
    inner class PermutationsOfNumbers {
        @Test
        fun `generates permutations`() {
            assertThat(permutationsOf(123).toList()).containsExactlyInAnyOrder(123, 132, 213, 231, 312, 321)
        }

        @Test
        fun `generates permutations efficiently`() {
            println(permutationsOf(1234567890).toList())
        }
    }

    @Nested
    inner class PermutationsOfNumbers2 {
        @Test
        fun `generates permutations`() {
            assertThat(permutationsOf2(123).toList()).containsExactlyInAnyOrder(123, 132, 213, 231, 312, 321)
        }

        @Test
        fun `generates permutations efficiently`() {
            println(permutationsOf2(1234567890).toList())
        }
    }

}
