// http://odz.sakura.ne.jp/projecteuler/?Problem+10

import kotlin.math.sqrt

fun isPrime(n: Int): Boolean {
    val max = sqrt(n.toDouble()).toInt()
    return (2..max).asSequence()
        .filter { n % it == 0 }
        .none()
}

fun sumPrimesBelow(n: Int) = (2..n).filter(::isPrime).sum()

assert(sumPrimesBelow(10) == 17)

println(sumPrimesBelow(2_000_000))
