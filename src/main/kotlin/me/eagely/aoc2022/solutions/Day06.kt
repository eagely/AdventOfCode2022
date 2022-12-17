package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode

class Day06 : AdventOfCode("src/main/resources/InputD6.aoc") {
    override fun getDay(): Int {
        return 6
    }

    override fun solvePart1(): String {
        val input = getInput().readText()
        return findFirstNonMatchingSet(input, 4).toString()
    }

    override fun solvePart2(): String {
        val input = getInput().readText()
        return findFirstNonMatchingSet(input, 14).toString()
    }

    private fun findFirstNonMatchingSet(input: String, size: Int): Int {
        var chars = input.substring(0, size)
        var matchingChars = 0
        var firstMatchPosition = 0
        for (i in size - 1 until input.length) {
            for (j in 0 until size)
                for (k in 0 until size)
                    if (chars[j] == chars[k] && j != k)
                        matchingChars++
            if (matchingChars == 0) {
                firstMatchPosition = input.indexOf(chars)
                break
            } else
                matchingChars = 0
            chars = chars.substring(1, size)
            chars += input[i]
        }
        return firstMatchPosition + size
    }
}
