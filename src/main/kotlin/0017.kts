// http://www.odz.sakura.ne.jp/projecteuler/?Problem+17
// ISBN978-4-04-893053-6 の 1.4 節を参照

val units = listOf("zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine")

val teens = listOf("ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

val tens = listOf("twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety")

fun convert1(n: Int): String = units[n]

//fun digit2(n: Int): Pair<Int, Int> = pairOf(n / 10, n % 10)
//fun convert2(n: Int): String = convine2(digit2(n))
//fun conbine2(p: Pair<Int, Int>): String = conbine2(p.first, p.second)
//fun conbine2(t: Int, u: Int): String = when {
//    t == 0 -> units[u]
//    t == 1 -> teens[u]
//    u == 0 -> tens[t]
//    else -> tens[t] + "-" + units[u]
//}

fun convert2(n: Int): String {
    val t = n / 10
    val u = n % 10
    return when {
        t == 0 -> units[u]
        t == 1 -> teens[u]
        u == 0 -> tens[t - 2]
        else -> tens[t - 2] + "-" + units[u]
    }
}

fun convert3(n: Int): String {
    val h = n / 100
    val t = n % 100
    return when {
        h == 0 -> convert2(t)
        t == 0 -> units[h] + " handred"
        else -> units[h] + " handred and " + convert2(t)
    }
}

fun convert(n: Int): String {
    val k = n / 1000
    val h = n % 1000
    return when {
        k == 0 -> convert3(h)
        h == 0 -> convert3(k) + " thausand"
        else -> convert3(k) + " thausand" + link(h) + convert3(h)
    }
}

fun link(h: Int): String = if (h < 100) " and " else " "

fun write(n: Int): String = convert(n)

// println(write(342))
// println(write(115))

println((1..1000)
        .map(::write)
        // .onEach { println(it) }  // test
        .map { it.count { it != ' ' && it != '-' }}
        .sum()
        .also { assert(it == 21124) }
)