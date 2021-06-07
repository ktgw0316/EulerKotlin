// http://odz.sakura.ne.jp/projecteuler/?Problem+5

fun fact(n: UInt): UInt = (1U..n).reduce { acc, i -> acc * i }

assert(fact(20U) == 2192834560U)

fun smallestMultiple(n: UInt): UInt {
    // return generateSequence(n) { it + 1U }
    //   .first { a -> (2U..n).all { a % it == 0U } }
    return (n..fact(n)).first { a -> (2U..n).all { a % it == 0U } }
}

assert(smallestMultiple(10U) == 2520U)

println(smallestMultiple(20U)) // 232792560
