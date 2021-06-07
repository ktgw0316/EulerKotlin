import kotlin.math.sqrt

// http://odz.sakura.ne.jp/projecteuler/?Problem+7

fun Int.isPrime(): Boolean {
    val sq = sqrt(this.toDouble()).toInt()
    return (2..sq).none { this % it == 0 }
}


fun nthPrime(n: Int): Int {
    return generateSequence(2) { it + 1 }
        .filter { it.isPrime() }
        .elementAt(n - 1)
}

assert(nthPrime(6) == 13)
println(nthPrime(10_001))
