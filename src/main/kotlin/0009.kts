// http://odz.sakura.ne.jp/projecteuler/?Problem+9

fun isPythagoreanTriplet(a: Int, b: Int, c: Int) = a * a + b * b == c * c

(1 until (1000 - 1)).forEach { a ->
    ((a+1) until 1000).forEach { b ->
        val c = 1000 - a - b
        if (isPythagoreanTriplet(a, b, c)) println(a * b * c)
    }
}