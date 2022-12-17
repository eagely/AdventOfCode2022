package me.eagely.aoc2022

import me.eagely.aoc2022.solutions.*

fun main() {
    val puzzles = listOf<AdventOfCode>(
        Day01(),
        Day02(),
        Day03(),
        Day04(),
        Day05(),
        Day06(),
        Day08(),
        Day10(),
        Day11(),
        Day16(),
        Day17()
    )
    puzzles.forEach { puzzle ->
        val day = java.lang.String.format("%02d", puzzle.getDay())
        println("Day " + day + " Part 1: " + puzzle.solvePart1())
        println("Day " + day + " Part 2: " + puzzle.solvePart2())
    }
}
