// http://odz.sakura.ne.jp/projecteuler/?Problem+1

val ceil = 1000
val sum = (1 until ceil).filter { n -> n % 3 == 0 || n % 5 == 0 }.sum()
println(sum)