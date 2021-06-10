// http://odz.sakura.ne.jp/projecteuler/?Problem+14

import kotlin.math.floor
import kotlin.math.log2

fun Double.isInteger() = floor(this) == this

tailrec fun collatzLength(n: Int, curr: Int = 1): Int {
    val l = log2(n.toDouble())
    return when {
        l.isInteger() -> curr + l.toInt() // n == 2^l
        n % 2 == 0 -> collatzLength(n / 2, curr + 1)
        else -> collatzLength(3 * n + 1, curr + 1)
    }
}

assert(collatzLength(13) == 10)

println(
    (1 until 1_000_000).asSequence()
        .map { collatzLength(it) }
        .maxOrNull()
)