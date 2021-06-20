// http://odz.sakura.ne.jp/projecteuler/?Problem+21

fun d(n: Int) = (1..(n / 2)).filter { n % it == 0 }.sum()

fun sumOfAmicable(a: Int): Int {
    val b = d(a)
    return when {
        a < b && d(b) == a -> a + b
        else -> 0
    }
}
assert(sumOfAmicable(220) == 220 + 284)

val N = 10000
(1 until N).asSequence()
    .map { sumOfAmicable(it) }
    .sum()
    .also { assert(it == 31626) }
