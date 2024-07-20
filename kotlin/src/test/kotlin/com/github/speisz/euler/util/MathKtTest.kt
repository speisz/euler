package com.github.speisz.euler.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
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
        fun `ignores duplicates`() {
            assertThat(permutationsOf(1, 1, 3).toList()).containsExactlyInAnyOrder(
                listOf(1, 1, 3),
                listOf(1, 3, 1),
                listOf(3, 1, 1),
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
            assertThat(permutationsOf(1234).toList())
                .containsExactlyInAnyOrder(1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321)
        }

        @Test
        fun `treats zeros correctly - no permutation with leading zero`() {
            assertThat(permutationsOf(1000).toList()).containsExactlyInAnyOrder(1000)
            assertThat(permutationsOf(1010).toList()).containsExactlyInAnyOrder(1001, 1010, 1100)
            assertThat(permutationsOf(1230).toList())
                .containsExactlyInAnyOrder(1023, 1032, 1203, 1230, 1302, 1320, 2013, 2031, 2103, 2130, 2301, 2310, 3012, 3021, 3102, 3120, 3201, 3210)
        }

        @Test
        @Disabled
        fun `generates permutations efficiently`() {
            println(permutationsOf(1234567890L).toList())
        }
    }

    @Nested
    inner class PermutationsOfNumbers2 {
        @Test
        fun `generates permutations`() {
            assertThat(permutationsOf2(123).toList()).containsExactlyInAnyOrder(123, 132, 213, 231, 312, 321)
        }

        @Test
        fun `treats zeros correctly - no permutation with leading zero`() {
            assertThat(permutationsOf2(1000).toList()).containsExactlyInAnyOrder(1000)
            assertThat(permutationsOf2(1010).toList()).containsExactlyInAnyOrder(1001, 1010, 1100)
            assertThat(permutationsOf2(1230).toList())
                .containsExactlyInAnyOrder(1023, 1032, 1203, 1230, 1302, 1320, 2013, 2031, 2103, 2130, 2301, 2310, 3012, 3021, 3102, 3120, 3201, 3210)
        }

        @Test
        @Disabled
        fun `generates permutations efficiently`() {
            println(permutationsOf2(1234567890L).toList())
        }
    }

    @Nested
    inner class IsPermutationOf {
        @Test
        fun `detects permutation`() {
            assertThat(
                listOf(1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321)
                    .map(Int::toLong)
                    .all(1234L::isPermutationOf)
            ).isTrue()

            assertThat(
                listOf(1022, 1202, 1220, 2012, 2021, 2102, 2120)
                    .map(Int::toLong)
                    .all(1220L::isPermutationOf)
            ).isTrue()
        }

        @Test
        fun `detects no permutation`() {
            assertThat(
                listOf(11222, 112, 1222)
                    .map(Int::toLong)
                    .any(1122L::isPermutationOf)
            ).isFalse()

            assertThat(
                listOf(12344, 123, 12340)
                    .map(Int::toLong)
                    .any(1234L::isPermutationOf)
            ).isFalse()

            assertThat(
                listOf(122, 212, 221)
                    .map(Int::toLong)
                    .any(1220L::isPermutationOf)
            ).isFalse()
        }
    }

    @Nested
    inner class Root {
        @Test
        fun `n-th root with precision`() {
            assertThat(2.root(3, precision = 0)).isEqualTo(1f)
            assertThat(8.root(3, precision = 0)).isEqualTo(2f)
            assertThat(10_000.root(4, precision = 0)).isEqualTo(10f)

            assertThat(2.root(3)).isEqualTo(1.2f)
            assertThat(2.root(3, precision = 1)).isEqualTo(1.2f)
            assertThat(2.root(3, precision = 2)).isEqualTo(1.25f)

            assertThat(42.root(7, precision = 5)).isEqualTo(1.70566f)
        }
    }
}
