package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode
import java.util.*

class Day04 : AdventOfCode("src/main/resources/InputD4.aoc") {
    override fun getDay(): Int {
        return 4
    }

    override fun solvePart1(): String {
        val input = getInput().readLines()
        return getContainedTasks(input).toString()
    }

    override fun solvePart2(): String {
        val input = getInput().readLines()
        return getOverlappingTasks(input).toString()
    }

    private fun getContainedTasks(input: List<String>): Int {
        val ranges = getRanges(input)
        var amount = 0
        for (i in ranges.indices)
            if (ranges[i][0].all { it in ranges[i][1] } || ranges[i][1].all { it in ranges[i][0] })
                amount++
        return amount
    }

    private fun getOverlappingTasks(input: List<String>): Int {
        val ranges = getRanges(input)
        var amount = 0
        for (i in ranges.indices)
            if (ranges[i][0].any { it in ranges[i][1] })
                amount++
        return amount
    }

    private fun getRanges(input: List<String>): LinkedList<List<IntRange>> {
        val ranges = LinkedList<List<IntRange>>()
        for (i in input.indices) {
            ranges.add(
                listOf(
                    IntRange(
                        input[i].substringBefore("-").toInt(),
                        input[i].substring(input[i].indexOf("-") + 1, input[i].indexOf(",")).toInt()
                    ), IntRange(
                        input[i].substring(input[i].indexOf(",") + 1, input[i].lastIndexOf("-")).toInt(),
                        input[i].substringAfterLast("-").toInt()
                    )
                )
            )
        }
        return ranges
    }
}
