package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode

class Day01: AdventOfCode("src/main/resources/InputD1.aoc") {
    override fun getDay(): Int {
        return 1
    }

    override fun solvePart1(): String {
        val input: List<String> = getInput().readLines()
        return getMostNutritiousBackpack(input)
    }

    override fun solvePart2(): String {
        val input: List<String> = getInput().readLines()
        return getSumOfThreeMostNutritiousBackpacks(input)
    }

    private fun getMostNutritiousBackpack(input: List<String>): String {
        var output = 0

        var backpack = 0

        for(i in input.indices) {
            if(input[i] != "")
                backpack += Integer.parseInt(input[i])
            else {
                if(backpack > output) output = backpack
                backpack = 0
            }
        }

        return output.toString()
    }
    private fun getSumOfThreeMostNutritiousBackpacks(input: List<String>): String {
        var output = 0

        var backpack = 0
        var first = 0
        var second = 0
        var third = 0

        for(i in input.indices) {
            if (input[i] != "")
                backpack += Integer.parseInt(input[i])
            else {
                if (backpack > first) first = backpack
                else if (backpack > second) second = backpack
                else if (backpack > third) third = backpack
                backpack = 0
            }
        }
        output = first + second + third

        return output.toString()
    }
}
