// http://odz.sakura.ne.jp/projecteuler/?Problem+14

import java.util.concurrent.ConcurrentHashMap

// val memo: Array<Int?> = arrayOfNulls(1_000_000)
//
// tailrec fun collatzLengthMemoised(m: Long, n: Long = m, curr: Int = 0): Int {
//     return when {
//         n < memo.size && memo[n.toInt()] != null -> curr + memo[n.toInt()]!!
//         n == 1L -> {
//             if (m < memo.size.toLong()) memo[m.toInt()] = curr + 1
//             curr + 1
//         }
//         n % 2 == 0L -> collatzLengthMemoised(m, n / 2, curr + 1)
//         else -> collatzLengthMemoised(m, 3 * n + 1, curr + 1)
//     }
// }

tailrec fun collatzLength(n: Long, curr: Int = 0): Int {
    return when {
        n == 1L -> curr + 1
        n % 2 == 0L -> collatzLength(n / 2, curr + 1)
        else -> collatzLength(3 * n + 1, curr + 1)
    }
}

assert(collatzLength(13L) == 10)
assert(collatzLength(7L) == 17)

println(
    (1L until 1_000_000L)
        .map { collatzLength(it) }
        .maxOrNull()
)
