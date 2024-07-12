package com.github.speisz.euler.p061

fun Int.connectsBehind(first: Int): Boolean = this - first * 100 % 10_000 in 0..99

fun Int.connectsTo(second: Int): Boolean = second.connectsBehind(this)
