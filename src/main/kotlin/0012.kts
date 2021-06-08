// http://odz.sakura.ne.jp/projecteuler/?Problem+12

val triangles = sequence<Int> {
    var curr = 1
    var next = 2
    while (true) {
        yield(curr)
        curr += next
        next++
    }
}

assert(triangles.take(7).last() == 28)

fun Int.divisorSize() = 2 + (2..this / 2).filter { this % it == 0 }.size

println(triangles.first { it.divisorSize() > 500 })