package me.eagely.aoc2022.solutions

import me.eagely.aoc2022.AdventOfCode

class Day08 : AdventOfCode("src/main/resources/InputD8.aoc") {
    override fun getDay(): Int {
        return 8
    }

    override fun solvePart1(): String {
        val input = getInput().readLines()
        return getVisibleTrees(input).toString()
    }

    override fun solvePart2(): String {
        val input = getInput().readLines()
        return getHighestScenicScore(input).toString()
    }

    private fun getHighestScenicScore(input: List<String>): Int {
        var output = 0

        for (i in input.indices) {
            for (j in 0 until input[0].length) {
                if(getScenicScore(input, i, j) > output)
                    output = getScenicScore(input, i, j)
            }
        }

        return output
    }

    private fun getScenicScore(input: List<String>, row: Int, col: Int): Int {
        var output = 0

        if(row == 0 || col == 0 || row == input.size - 1 || col == input[0].length - 1) return 0
        output = getScenicScoreUp(input, row, col) *
                getScenicScoreDown(input, row, col) *
                getScenicScoreLeft(input, row, col) *
                getScenicScoreRight(input, row, col)
        //println("Up ${getScenicScoreUp(input, row, col)} Down ${getScenicScoreDown(input, row, col)} Left ${getScenicScoreLeft(input, row, col)} Right ${getScenicScoreRight(input, row, col)}")

        return output
    }

    private fun getScenicScoreUp(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Int {
        if(row == 0) return 0
        var upRow = row

        if(originalSize > input[--upRow][col].digitToInt())
            return getScenicScoreUp(input, upRow, col, originalSize) + 1
        return 1
    }

    private fun getScenicScoreDown(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Int {
        if(row == input.size - 1) return 0
        var downRow = row

        if(originalSize > input[++downRow][col].digitToInt())
            return getScenicScoreDown(input, downRow, col, originalSize) + 1
        return 1
    }

    private fun getScenicScoreLeft(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Int {
        if(col == 0) return 0
        var leftCol = col

        if(originalSize > input[row][--leftCol].digitToInt())
            return getScenicScoreLeft(input, row, leftCol, originalSize) + 1
        return 1
    }

    private fun getScenicScoreRight(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Int {
        if(col == input[0].length - 1) return 0
        var rightCol = col

        if(originalSize > input[row][++rightCol].digitToInt())
            return getScenicScoreRight(input, row, rightCol, originalSize) + 1
        return 1
    }

    private fun getVisibleTrees(input: List<String>): Int {
        var output = 0

        for (i in input.indices) {
            for (j in 0 until input[0].length) {
                if (isTreeVisible(input, i, j)) {
                    output++
                }
            }
        }
        return output
    }

    private fun isTreeVisible(input: List<String>, row: Int, col: Int): Boolean {
        var output = false
        val maxRow = input.size - 1
        val maxCol = input[0].length - 1

        output = if (row == 0 || col == 0 || row == maxRow || col == maxCol) true
        else
            isTreeVisibleUp(input, row, col) ||
                    isTreeVisibleDown(input, row, col) ||
                    isTreeVisibleLeft(input, row, col) ||
                    isTreeVisibleRight(input, row, col)

        return output
    }

    private fun isTreeVisibleUp(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Boolean {
        if (row == 0) return true

        var upRow = row

        if (originalSize > input[--upRow][col].digitToInt())
            return isTreeVisibleUp(input, upRow, col, originalSize)

        return false
    }

    private fun isTreeVisibleDown(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Boolean {
        if (row == input.size - 1) return true

        var downRow = row

        if (originalSize > input[++downRow][col].digitToInt())
            return isTreeVisibleDown(input, downRow, col, originalSize)

        return false
    }

    private fun isTreeVisibleLeft(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Boolean {
        if (col == 0) return true

        var leftCol = col

        if (originalSize > input[row][--leftCol].digitToInt())
            return isTreeVisibleLeft(input, row, leftCol, originalSize)

        return false
    }

    private fun isTreeVisibleRight(input: List<String>, row: Int, col: Int, originalSize: Int = input[row][col].digitToInt()): Boolean {
        if (col == input[0].length - 1) return true

        var rightCol = col

        if(originalSize > input[row][++rightCol].digitToInt())
            return isTreeVisibleRight(input, row, rightCol, originalSize)

        return false
    }

}
