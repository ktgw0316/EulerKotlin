// http://odz.sakura.ne.jp/projecteuler/?Problem+10

import kotlin.math.sqrt

fun isPrime(n: Long): Boolean {
    val max = sqrt(n.toDouble()).toLong()
    return (2L..max).asSequence()
        .filter { n % it == 0L }
        .none()
}

fun sumPrimesBelow(n: Long) = (2L..n).filter(::isPrime).sum()

assert(sumPrimesBelow(10L) == 17L)

sumPrimesBelow(2_000_000L)
        .also { assert(it == 142913828922L) }
