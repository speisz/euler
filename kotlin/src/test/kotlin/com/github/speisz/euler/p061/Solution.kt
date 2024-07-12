package com.github.speisz.euler.p061

import com.github.speisz.euler.util.permutationsOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    @Test
    fun solution() {
        val sum = permutationsOf(
            triangles().toList(),
            squares().toList(),
            pentagonals().toList(),
            hexagonals().toList(),
            heptagonals().toList(),
            octagonals().toList()
        ).firstNotNullOf(::findCyclicConnected6Tuple)
            .also(::println)
            .sum()

        assertThat(sum).isEqualTo(28_684)
    }

    private fun findCyclicConnected6Tuple(polygonalsPermutation: List<List<Int>>): List<Int>? = polygonalsPermutation[0].asSequence()
        .map(::listOf)
        .addConnectedRemaining(1, polygonalsPermutation)
        .firstOrNull { it.last().connectsTo(it.first()) }

    private fun Sequence<List<Int>>.addConnectedRemaining(currentIndex: Int, polygonalsPermutation: List<List<Int>>): Sequence<List<Int>> =
        if (currentIndex > polygonalsPermutation.lastIndex) this
        else flatMap { connectedList ->
            polygonalsPermutation[currentIndex].asSequence()
                .filter(connectedList.last()::connectsTo)
                .map { connectedList + it }
        }.addConnectedRemaining(currentIndex + 1, polygonalsPermutation)

    @Test
    fun print() {
        println(triangles().toList())
        println(squares().toList())
        println(pentagonals().toList())
        println(hexagonals().toList())
        println(heptagonals().toList())
        println(octagonals().toList())
    }
}
