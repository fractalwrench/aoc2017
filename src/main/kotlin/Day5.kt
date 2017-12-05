fun main(args: Array<String>) {
    val resourceReader = ResourceReader()
    println(calculateJumpCount(resourceReader.readResource("5.txt")))
}

fun calculateJumpCount(input: String): Int {
    val instructions = input
            .split("\n")
            .map { it.toInt() }
            .toMutableList()

    val max = instructions.size
    var k = 0
    var jumps = 0

    while (k in 0..(max - 1)) {
        val n = instructions[k]
        instructions[k] = n + 1 // increment jump instruction
        k += n
        jumps++
    }
    return jumps
}
