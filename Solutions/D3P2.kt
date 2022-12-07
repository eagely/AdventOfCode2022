import java.io.File

fun main() {
    val input: List<String> = File("src/main/resources/InputD3.aoc").readLines()

    var firstCompartment: String
    var secondCompartment: String
    var thirdCompartment: String
    var sharedItem = ' '
    var output = 0
    var i = 0
        while(i < input.size) {
        firstCompartment = input[i]
        secondCompartment = input[i+1]
        thirdCompartment = input[i+2]
        println("First Compartment: $firstCompartment")
        println("Second Compartment: $secondCompartment")
        println("Third Compartment: $thirdCompartment")
        for(j in firstCompartment.indices) {
            if(secondCompartment.indexOf(firstCompartment[j]) != -1 && thirdCompartment.indexOf(firstCompartment[j]) != -1) {
                sharedItem = firstCompartment[j]
                break
            }
        }
        output += if(sharedItem.isUpperCase())
            sharedItem.code - 38
        else
            sharedItem.code - 96
        i += 3
    }
    println(output)
}
