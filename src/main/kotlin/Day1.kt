fun main(args: Array<String>) {
    if (args.size != 1) {
        System.exit(-1)
    }

    println(findSumOfDigits(args[0]))

//  find the sum of all digits that match the next digit in the list.
//  The list is circular

}

fun findSumOfDigits(input: String): Int {
    val ary = input.toCharArray()
    var sum = 0

    for ((index, c) in ary.withIndex()) {

        val nextDigitIndex= if (index + 1 == ary.size) {
            0
        } else {
            index + 1
        }

        if (c == ary[nextDigitIndex]) {
            val toInt = convertToInt(c)
            sum += toInt
        }
    }
    return sum
}

private fun convertToInt(c: Char): Int {
    return c.toInt() - 48
}