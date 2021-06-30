// http://www.odz.sakura.ne.jp/projecteuler/?Problem+16

import java.math.BigInteger.ONE

val TWO = ONE + ONE

fun pow2DigitSum(n: Int) =
        TWO.pow(n)
                .toString()
                .asSequence()
                .map(Char::digitToInt)
                .sum()
assert(pow2DigitSum(15) == 26)

pow2DigitSum(1000)
        .also { assert(it == 1366) }