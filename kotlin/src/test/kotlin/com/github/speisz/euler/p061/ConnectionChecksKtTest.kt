package com.github.speisz.euler.p061

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ConnectionChecksKtTest {

    @Nested
    inner class ConnectsBehind {
        @Test
        fun `detects connection`() {
            assertThat(4511.connectsBehind(2245)).isTrue()
            assertThat(8999.connectsBehind(9989)).isTrue()
            assertThat(1200.connectsBehind(1112)).isTrue()
        }

        @Test
        fun `detects no connection`() {
            assertThat(4511.connectsBehind(2246)).isFalse()
            assertThat(9999.connectsBehind(9989)).isFalse()
            assertThat(1112.connectsBehind(1112)).isFalse()
        }
    }

    @Test
    fun `detects connection`() {
        assertThat(areConnected(2245, 4511)).isTrue()
        assertThat(areConnected(9989, 8999)).isTrue()
        assertThat(areConnected(1112, 1200)).isTrue()
    }

    @Test
    fun `detects no connection`() {
        assertThat(areConnected(2246, 4511)).isFalse()
        assertThat(areConnected(9989, 9999)).isFalse()
        assertThat(areConnected(1112, 1112)).isFalse()
    }

    private fun areConnected(first: Int, second: Int): Boolean = second - first * 100 % 10_000 in 0..99
}
