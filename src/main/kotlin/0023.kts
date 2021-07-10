// http://odz.sakura.ne.jp/projecteuler/?Problem+23

fun sumOfProperDivisors(n: Int) = (1 until n).filter { n % it == 0 }.sum()
assert(sumOfProperDivisors(28) == 28)
assert(sumOfProperDivisors(28) == 28)

fun isAbundant(n: Int) = n < sumOfProperDivisors(n)

val abundants = (12 until 28123 - 12).filter(::isAbundant)

fun isSumOfTwoAbundant(n: Int): Boolean {
    return when {
        n < 24 -> false
        n > 28123 -> true
        else -> abundants
                .filter { it <= n / 2 }
                .any { abundants.contains(n - it) }
    }
}
assert(isSumOfTwoAbundant(24))
assert(!isSumOfTwoAbundant(25))
assert(isSumOfTwoAbundant(28123))

val sum = (1..28123).asSequence()
        .filter { !isSumOfTwoAbundant(it) }
        .sum()
println(sum)
assert(sum == 4179871)