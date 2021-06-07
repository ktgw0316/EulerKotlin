// http://odz.sakura.ne.jp/projecteuler/?Problem+6

fun squareSum(n: Int) = (1..n).map { it * it }.sum()

fun sumSquare(n: Int): Int {
    val sum = (1..n).sum()
    return sum * sum
}

assert(squareSum(10) == 385)
assert(sumSquare(10) == 3025)

println(sumSquare(100) - squareSum(100))
