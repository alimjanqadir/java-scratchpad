package scratchpad.algo

import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.sqrt


fun main(args: Array<String>) {
    for (i in 2..100) {
        if (isSquare(i)) {
            println("i: $i count: ${numSquares(i)}")
        }
    }
}

fun numSquares(n: Int): Int {
    val sqrt = sqrt(n.toDouble())
    val largestSquareCandidate = (sqrt + 1) * (sqrt + 1)

    val x = if (largestSquareCandidate <= Int.MAX_VALUE) {
        largestSquareCandidate.toInt()
    } else {
        Int.MAX_VALUE
    }

    return floor(sqrt(x.toDouble())).toInt() - 2
}

fun isSquare(n: Int): Boolean {
    return n % sqrt(n.toDouble()) == 0.0
}