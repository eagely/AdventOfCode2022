package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode

class Day02: AdventOfCode("src/main/resources/InputD2.aoc") {
    override fun getDay(): Int {
        return 2
    }

    override fun solvePart1(): String {
        val input: List<String> = getInput().readLines()
        return parseGames(input).toString()
    }

    override fun solvePart2(): String {
        val input: List<String> = getInput().readLines()
        return parseTopSecretGames(input).toString()
    }

    private fun getGameResult(game: String): Int {
        var result = game.last().code - 87
        result += if (game.last().code - game.first().code == 23) 3 else if (game.last().code - game.first().code == 21 || game.last().code - game.first().code == 24) 6 else 0
        return result
    }

    private fun parseGames(input: List<String>): Int {
        var output = 0

        for (i in input.indices)
            output += getGameResult(input[i])

        return output
    }

    private fun getTopSecretGameResult(game: String): Int {
        var result =
            if(game.last() == 'Y') game.first().code - 64
            else if(game.last() == 'Z') (if(game.first() == 'C') 1 else game.first().code - 63)
            else (if (game.first() == 'A') 3 else game.first().code - 65)
        result += (game.last().code - 88) * 3
        return result
    }

    private fun parseTopSecretGames(input: List<String>): Int {
        var output = 0

        for (i in input.indices)
            output += getTopSecretGameResult(input[i])

        return output
    }
}
