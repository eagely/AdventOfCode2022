package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode
import java.io.File

class Day10 : AdventOfCode("src/main/resources/InputD10.aoc", "src/main/resources/OutputD10.aoc") {
    override fun getDay(): Int {
        return 10
    }

    override fun solvePart1(): String {
        val input = getInput().readLines()
        return getSignalStrengthSum(input).toString()
    }

    override fun solvePart2(): String {
        val input = getInput().readLines()
        drawScreen(input)
        return "Output put in ${getOutput()}"
    }

    private fun getSignalStrengthSum(input: List<String>): Int {
        var total = 0
        var cycle = 0
        var x = 1
        val signalStrengths = ArrayList<Int>()

        for (i in input.indices) {
            if (input[i] == "noop") {
                if ((++cycle - 20) % 40 == 0) {
                    signalStrengths.add(x * cycle)
                }
                continue
            }
            if ((++cycle - 20) % 40 == 0)
                signalStrengths.add(x * cycle)

            if ((++cycle - 20) % 40 == 0)
                signalStrengths.add(x * cycle)
            x += input[i].substringAfter(" ").toInt()
        }
        for (i in signalStrengths.indices)
            total += signalStrengths[i]
        return total
    }

    private fun drawScreen(input: List<String>) {
        val output = getOutput()
        var cycle = 0
        var x = 1

        for (i in input.indices) {
            cycle++
            if (input[i] == "noop") {
                drawPixel(cycle, x, output)
                continue
            }
            drawPixel(cycle++, x, output)
            drawPixel(cycle, x, output)
            x += input[i].substringAfter(" ").toInt()
        }
    }

    private fun drawPixel(cycle: Int, x: Int, file: File) {
        if ((cycle - 1) % 40 in x - 1..x + 1)
            file.appendText("#")
        else
            file.appendText(".")
        if (cycle % 40 == 0)
            file.appendText("\n")
    }
}
