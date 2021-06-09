// http://odz.sakura.ne.jp/projecteuler/?Problem+12
// cf. https://freak-da.hatenablog.com/entry/20100729/p1

import java.util.concurrent.ConcurrentHashMap

val memo = ConcurrentHashMap<Int, Int?>()

fun divisorSize(n: Int): Int {
    return memo.computeIfAbsent(n) {
        // val r = Math.sqrt(n.toDouble()).toInt()
        // if (n == r * (r + 1)) {
        //     divisorSize(r) * divisorSize(r + 1)
        // } else {
            2 + (2..n / 2).filter { n % it == 0 }.size
        // }
    }!!
}

fun triangleDivisorSize(i: Int): Pair<Int, Int> {
    val (a, b) = when {
        i % 2 == 0 -> i / 2 to i + 1
        else -> i to (i+1) / 2
    }
    return a * b to divisorSize(a) * divisorSize(b)
}

assert(triangleDivisorSize(7) == 28 to 6)

val ans = (1..Int.MAX_VALUE).asSequence()
        .map(::triangleDivisorSize)
        .first { it.second > 500 }
        .first
println(ans)
