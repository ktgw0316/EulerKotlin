// http://odz.sakura.ne.jp/projecteuler/?Problem+22

import java.io.File

val sorted: Sequence<IndexedValue<String>> = File("p022_names.txt")
    .useLines {
        it.first()
            .splitToSequence(',')
            .sorted()
    }
    .withIndex()
assert(sorted.find { it.value == "\"COLIN\"" }!!.index + 1 == 938)

fun letterSum(name: String): Int {
    val c2i = ('A'..'Z')
        .mapIndexed { i, c -> c to i + 1 }
        .toMap()
    
    return name
        .toCharArray()
        .fold(0) { acc, c -> acc + c2i.getOrDefault(c, 0) }
}
assert(letterSum("\"COLIN\"") == 53)

sorted
    .map { (it.index + 1) * letterSum(it.value) }
    .sum()
    .also { assert(it == 871_198_282) }