#!/usr/bin/env kscript
// http://www.odz.sakura.ne.jp/projecteuler/?Problem+29

import java.math.BigInteger

fun <A> cons(car: A, cdr: List<A>): List<A> = listOf(car) + cdr

tailrec fun _row(a: Int, b: Int, l: List<BigInteger>): List<BigInteger> = when {
    b == 2 -> l
    else -> _row(a, b - 1, cons(l[0] * a.toBigInteger(), l))
}

fun row(a: Int, max: Int) = _row(a, max, listOf((a * a).toBigInteger()))

tailrec fun _matrix(n: Int, a: Int, l: List<BigInteger>): List<BigInteger> = when {
    a == 2 -> l
    else -> _matrix(n, a - 1, row(a - 1, n) + l)
}

fun matrix(n: Int) = _matrix(n, n, row(n, n))

// println(matrix(5)
//         .distinct()
//         .sorted()
//         // .size
// )

println(matrix(100)
        .distinct()
        .size
        .also { assert(it == 9183) }
)