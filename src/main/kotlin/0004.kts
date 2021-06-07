// http://odz.sakura.ne.jp/projecteuler/?Problem+4

// fun reverse(n: UInt): UInt {
//     val list = mutableListOf<UInt>()
//     var i = n
//     while (i > 0U) {
//         val j = i / 10U
//         val rightmost = i - j * 10U
//         list.add(rightmost)
//         i = j
//     }
//
//     return list.reduce { a, b -> a * 10U + b }
// }
//
// fun reverse(n: UInt) = n.toString().reversed().toUInt()
// fun isPalindrome(n: UInt) = n == reverse(n)

fun isPalindrome(str: String) = str == str.reversed()

fun largestPalindrome(max: UInt, min: UInt = 1U): UInt {
    val seq = (max downTo min).asSequence()
    return seq
        .flatMap { i -> seq.map { i * it } }
        .first { isPalindrome(it.toString()) }
}

assert(largestPalindrome(99U) == 9009U)
println(largestPalindrome(999U))
