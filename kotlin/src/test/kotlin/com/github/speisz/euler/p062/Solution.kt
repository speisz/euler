package com.github.speisz.euler.p062

import com.github.speisz.euler.util.isPermutationOf
import com.github.speisz.euler.util.naturalNumbers
import com.github.speisz.euler.util.pow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.min

class Solution {

    @Test
    fun solution() {
        val cubes = naturalNumbers().map { it.pow(3) }.filter { it > 100_000_000_000 }.takeWhile { it < 1_000_000_000_000 }.toList()

        val smallestCubeWith5CubicPermutations = cubes.asSequence()
            .mapIndexedNotNull { index, cube ->
                cubes.subList(min(index + 1, cubes.lastIndex), cubes.lastIndex).asSequence()
                    .filter(cube::isPermutationOf)
                    .take(4).toList()
                    .takeIf { it.size == 4 }
                    // ?.also { println("$cube: $it") }
                    ?.let { cube }
            }.first()

        assertThat(smallestCubeWith5CubicPermutations).isEqualTo(127_035_954_683)
    }
}
