package lab_6

import kotlin.math.pow

/**
 * Задача 6. Циклы, ряды.
 *
 * При некоторых заданных x (допустимые значения x – интервал (-R, R)), n и e, определяемых вводом, вычислить:
 * 1) сумму n слагаемых заданного вида; +
 * 2) сумму тех слагаемых, которые по абсолютной величине больше e;
 * 3) сумму тех слагаемых, которые по абсолютной величине больше e/10;
 * 4) значение функции с помощью методов Math. +
 *
 * При вычислениях необходимо выразить an (n-ый член ряда) как зависимость от n,
 * an-1 и x, т.е. виде an = f(n, an-1, x).
 * Другие варианты решения не принимаются. Использовать только 1 цикл.
 *
 * Вар. 15
 * ch(x) = 1 + x^2/2! + x^4/4! + x^6/6! + ... (R=беск)
 */
fun main () {
      println("Check factorials:\n" +
              "${calculateFactorial(0)}\n" +
              "${calculateFactorial(1)}\n" +
              "${calculateFactorial(4)}\n" +
              "${calculateFactorial(5)}")
      var x = 2.0
      val res1 = kotlin.math.cosh(x)
      val res2 = calculateCh(x, 10)
      println("Solution:\n" +
              "$res1\n" +
              "$res2")

}

fun calculateFactorial (N: Int) : Int {
      if (N == 0) return 1
      var res = 1
      for (i in 1..N) {
            res *= i
      }
      return res
}

fun calculateCh (x: Double, N: Int) : Double {
      var res = 0.0
      for (i in 0..N step 2) {
            res += x.pow(i)/ calculateFactorial(i)
      }
      return res
}
