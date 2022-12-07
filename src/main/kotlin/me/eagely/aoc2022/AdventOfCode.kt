package me.eagely.aoc2022

import java.io.File

/**
 * Abstract class that represents the solution to an Advent of Code puzzle.
 * Constructor which accepts the relative file path of the input file (Format as InputDayX.aoc where X is the day number)
 */
abstract class AdventOfCode(private val inputFilePath: String) {

    /**
     * Return the File object of the input file
     * @return the File object of the input file
     */
    fun getInput(): File {
        return File(this.inputFilePath)
    }

    /**
     *  Return the day number of the puzzle
     *  @return the day number of the puzzle
     */
    abstract fun getDay(): Int

    /**
     * Return the solution to part 1 of the puzzle
     * @return the solution to part 1 of the puzzle
     */
    abstract fun solvePart1(): String

    /**
     * Return the solution to part 2 of the puzzle
     * @return the solution to part 2 of the puzzle
     */
    abstract fun solvePart2(): String
}
