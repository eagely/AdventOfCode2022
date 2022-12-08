import me.eagely.aoc2022.AdventOfCode
import me.eagely.aoc2022.solutions.Day01
import me.eagely.aoc2022.solutions.Day02
import me.eagely.aoc2022.solutions.Day03

fun main(args: Array<String>) {
    val puzzles = listOf<AdventOfCode>(
        Day01(),
        Day02(),
        Day03()
    )
    puzzles.forEach { puzzle ->
        val day = java.lang.String.format("%02d", puzzle.getDay())
        println("Day " + day + " Part 1: " + puzzle.solvePart1())
        println("Day " + day + " Part 2: " + puzzle.solvePart2())
    }
}
