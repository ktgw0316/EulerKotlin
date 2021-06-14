// http://odz.sakura.ne.jp/projecteuler/?Problem+15

import kotlin.math.pow

fun product(s: Iterable<Int>) = s.map(Int::toULong).reduce { acc, i -> acc * i }

// (product(21..40) / product(2..20))  // overflow
(2.0.pow(10).toULong() * product(21..39 step 2) / product(2..10))
        .also { assert(it == 137846528820UL) }
