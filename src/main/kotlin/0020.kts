// http://www.odz.sakura.ne.jp/projecteuler/?Problem+20

import java.math.BigInteger.ONE

fun fact(n: Int) = (2..n).fold(ONE, { acc, i -> acc * i.toBigInteger() })
assert(fact(10).intValueExact() == 3628800)

fun digitSum(n: Number) =
        n.toString()
                .asSequence()
                .map(Char::digitToInt)
                .sum()
assert(digitSum(3628800) == 27)

digitSum(fact(100))
        .also { assert(it == 648) }
