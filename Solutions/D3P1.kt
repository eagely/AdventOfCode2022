import java.io.File

fun main() {
    val input: List<String> = File("src/main/resources/InputD3.aoc").readLines()

    var firstCompartment: String
    var secondCompartment: String
    var sharedItem = ' '
    var output = 0

    for(i in input.indices) {
        firstCompartment = input[i].substring(0, input[i].length / 2)
        secondCompartment = input[i].substring(input[i].length / 2)
        for(j in firstCompartment.indices) {
            if(secondCompartment.indexOf(firstCompartment[j]) != -1) {
                sharedItem = firstCompartment[j]
                break
            }
        }
        output += if(sharedItem.isUpperCase())
            sharedItem.code - 38
        else
            sharedItem.code - 96
    }
    println(output)
}
