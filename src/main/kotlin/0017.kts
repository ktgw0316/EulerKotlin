// http://www.odz.sakura.ne.jp/projecteuler/?Problem+17

val dictStr1 = mapOf(
        0 to "", 1 to "one", 2 to "two", 3 to "three", 4 to "four",
        5 to "five", 6 to "six", 7 to "seven", 8 to "eight", 9 to "nine",
        10 to "ten", 11 to "eleven", 12 to "twelve", 13 to "thirteen",
        14 to "fourteen")  // not "forteen"
val dictStr2 = mapOf(
        0 to "", 1 to "", 2 to "twen", 3 to "thir", 4 to "for",
        5 to "fif", 6 to "six", 7 to "seven", 8 to "eigh", 9 to "nine")

fun write(n: Int): String {
    val n1 = n - n / 10 * 10
    val n2 = n / 10 - n / 100 * 10
    val n3 = n / 100 - n / 1000 * 10
    val n4 = n / 1000
    var str = ""
    if (n4 != 0) str += dictStr1[n4] + " thousand "
    if (n3 != 0) str += dictStr1[n3] + " handred"
    if (n2 == 0 && n1 == 0) return str
    if (n4 != 0 || n3 != 0) str += " and "
    val n21 = 10 * n2 + n1
    str += when {
        n21 <= 14 -> dictStr1[n21]
        n21 <= 19 -> dictStr2[n1] + "teen"
        else -> dictStr2[n2] + "ty " + dictStr1[n1]
    }
    return str
}

(1..1000)
        .map(::write)
        // .onEach { println(it) }  // test
        .map { it.count { it != ' ' }}
        .sum()
        .also { assert(it == 21124) }