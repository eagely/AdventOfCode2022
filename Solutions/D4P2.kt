import java.io.File

fun main() {
    val input: List<String> = File("src/main/resources/InputD4.aoc").readLines()

    var min1: Int
    var max1: Int
    var min2: Int
    var max2: Int
    var output = 0
    for (i in input.indices) {
        min1 = Integer.parseInt(input[i].substringBefore("-"))
        max1 = Integer.parseInt(input[i].substring(input[i].indexOf("-") + 1, input[i].indexOf(",")))
        min2 = Integer.parseInt(input[i].substring(input[i].indexOf(",") + 1, input[i].indexOf("-", input[i].indexOf(","))))
        max2 = Integer.parseInt(input[i].substring(input[i].indexOf("-", input[i].indexOf(",")) + 1))

        if ((min2 in min1 .. max1) || (min1 in min2 .. max2) || (max1 in min2 .. max2) || (max2 in min1 .. max1))
            output++
    }
    println("The number of overlaps whether full or partial is $output")
}
