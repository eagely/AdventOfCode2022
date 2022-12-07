import java.io.File
import java.util.*

fun main() {
    val input: List<String> = File("src/main/resources/InputD5.aoc").readLines()
    var stack = ArrayList<Stack<Char>>()
    var temporaryDeposit = Stack<Char>()

    var move: Int
    var from: Int
    var to: Int

    var bottomOfInputStack = 0
    while(input[bottomOfInputStack++] != "") {}
    bottomOfInputStack -= 2
    val amountOfStacks = input[bottomOfInputStack].replace(" ", "").last().digitToInt()

    for (i in 0 until amountOfStacks)
        stack.add(Stack<Char>())

    for (i in 0 until bottomOfInputStack)
        for (j in 0 until amountOfStacks)
            if (input[i][j*4+1] != ' ')
                stack[j].push(input[i][j*4+1])

    for (i in 0 until amountOfStacks) {
        stack[i].reverse()
    }
    for (i in bottomOfInputStack + 2 until input.size) {
        move = Integer.parseInt(input[i].substring(input[i].indexOf("move ") + 5, input[i].indexOf(" from ")))
        from = Integer.parseInt(input[i].substring(input[i].indexOf("from ") + 5, input[i].indexOf(" to "))) - 1
        to = Integer.parseInt(input[i].substringAfter(" to ")) - 1
        for(j in 0 until move) {
            stack[to].push(stack[from].peek())
            stack[from].pop()
        }
    }

    println("The top elements of each stack are ")
    for (i in 0 until amountOfStacks) {
        println(stack[i].peek())
    }
    println("These are the stacks $stack")
}
