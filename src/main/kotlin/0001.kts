// http://odz.sakura.ne.jp/projecteuler/?Problem+1

val ceil = 1000
val sum = (1..ceil-1).filter { n -> n % 3 == 0 || n % 5 == 0 }.sum()
println(sum)