// http://odz.sakura.ne.jp/projecteuler/?Problem+28

 fun spiralDiagonalSum(n: Int): Int {
     var sum = 1
     var last = 1
     for (i in 2..n-1 step 2) {
         var next = last + 4 * i
         // last + i + last + 2 * i + last + 3 * i + last + 4 * i
         sum += 4 * last + 10 * i
         last = next
     }
     return sum
 }

assert(spiralDiagonalSum(5) == 101)

spiralDiagonalSum(1001)
    .also { assert(it == 669171001) }
