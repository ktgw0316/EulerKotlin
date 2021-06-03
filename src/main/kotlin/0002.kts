import java.util.*

// http://odz.sakura.ne.jp/projecteuler/?Problem+2

val fibonacci = sequence<Long> {
    var prev = 1L
    var curr = 1L

    while (true) {
        yield(curr)
        val next = curr + prev
        prev = curr
        curr = next
    }
}

val fibonacciR = sequence<Long> {
    tailrec fun fibR(n: Int, prev: Long, curr: Long): Long =
        when (n) {
            0 -> prev
            1 -> curr
            else -> fibR(n - 1, curr, prev + curr)
        }

    fun fib(n: Int): Long = fibR(n, 1, 1)

    var i = 1
    while (true) {
        yield(fib(i++))
    }
}

fibonacci
    .take(10)
    .forEach { println(it) }

val sumOfEven = fibonacci
    .takeWhile { it <= 4_000_000 }
    .filter { it % 2 == 0L }
    .sum()
println(sumOfEven)