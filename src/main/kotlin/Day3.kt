fun main(args: Array<String>) {
    if (args.size != 1) {
        System.exit(-1)
    }
    println(calculateSteps(args[0].toInt()))
}

//     35  34  33  32  31
// 17  16  15  14  13  30
// 18   5   4   3  12  29
// 19   6   1   2  11  28
// 20   7   8   9  10  27
// 21  22  23   24 25  26
//                     XX

//Data from square 1 is carried 0 steps, since it's at the access port.
//Data from square 12 is carried 3 steps, such as: down, left, left.
//Data from square 23 is carried only 2 steps: up twice.
//Data from square 1024 must be carried 31 steps.

fun calculateSteps(input: Int): Int {
    if (input <= 1) {
        return 0
    }

    // each ring adds one step. the last value in each ring is equal
    // to a squared odd integer, meaning the algorithm has the following
    // constraints:
    //
    // O(sqrt(n)) where n % 2 == 1
    var steps = 1
    var power = 3

    for (n in 3 .. sqrt(input) step 2) {
        steps++
        power = n
    }

    // remaining bits on outermost ring.
    // 2 additional numbers are added for each corner.
    val remainingBits = input - power.times(power)


    // get the total count for a full ring
    // n => (n - 1) * 8
    val ringTotalCount = (power - 1) * 8

    // 1 => 0
    // 3 => 8  (1, 3, 5, 7)
    // 5 => 16 (2, 6, 10, 14)
    // 7 => 24 (3, 9, ...)
    //

    // 2, 4, 6
    power += 2 // move onto remaining power
    val step = power - 1
    val range = (step / 2 .. ringTotalCount step step).toList()

    var minSteps = Int.MAX_VALUE

    range.forEach({
        val delta = Math.abs(it - remainingBits)
        if (delta < minSteps) {
            minSteps = delta
        }
    })
    steps += minSteps
    return steps
}

private fun sqrt(input: Int) = Math.floor(Math.sqrt(input.toDouble())).toInt()