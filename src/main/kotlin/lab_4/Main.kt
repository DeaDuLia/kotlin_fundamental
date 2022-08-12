package lab_4

import kotlin.math.pow

/**
 * Задача 4. Циклы
 * Вар. 1
 * Составить программу вычисления суммы
 */
fun main () {
    val sum1 = calculateFirstSum(50)
    println("Solution:" +
            "\bsum: $sum1")
    val sum2 = calculateSecondSum(128)
    println("Solution:" +
            "\bsum2: $sum2")

}

fun calculateFirstSum (N: Int) : Double {
    var sum = 0.0
    for (i in 1..N) {
        sum += 1 / i.toDouble().pow(3)
    }
    return sum
}

fun calculateSecondSum (N: Int) : Double {
    var sum = 0.0
    for (i in 2..N step 2) {
        sum += 1 / i.toDouble().pow(2)
    }
    return sum
}






