// http://odz.sakura.ne.jp/projecteuler/?Problem+3

// fun primeFactors(n: Long): List<Long> {
//     val list = mutableListOf<Long>()
//     val sq = Math.sqrt(n.toDouble()).toLong()
//     var m = n
//     for (i in 2..sq) {
//         if (m % i == 0L) {
//             list.add(i)
//             while (m % i == 0L) {
//                 m /= i
//             }
//         }
//     }
//     return list
// }

fun isPrime(n: Long): Boolean {
    val sq = Math.sqrt(n.toDouble()).toLong()
    return (2..sq)
        .filter { n % it == 0L }
        .isEmpty()
}

fun primeFactors(n: Long): Sequence<Long> {
    val sq = Math.sqrt(n.toDouble()).toLong()
    return (sq downTo 2)
        .asSequence()
        .filter { n % it == 0L }
        .filter { isPrime(it) }
}

primeFactors(13195L)
    .toList()
    .reversed()
    .forEach{ println(it) }

println(primeFactors(600851475143L).first())