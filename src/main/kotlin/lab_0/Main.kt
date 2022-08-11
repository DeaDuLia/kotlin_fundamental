import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println("Hello world!")
    val a = readLine()?.toDouble()
    val b = readLine()?.toDouble()
    val c = readLine()?.toDouble()
    calculateSquareEquation(a!!, b!!, c!!)
}

fun sum (a: Int, b: Int): Int {
    return a + b;
}

fun sum2(a: Int, b: Int) = a+b;

// ax + bx^2 + c = 0
/*
D = b^2 - 4ac;
>=0: x = (-b +- кор(D))/2a
<0: x = x_x +- x_yi
 */
fun calculateSquareEquation (a: Double, b: Double, c: Double) {
    val D = b.pow(2) - 4*a*c
    val eps = 0.0000001
    if (D > 0) {
        val x1 = (-b + sqrt(D))/(2*a)
        val x2 = (-b - sqrt(D))/(2*a)
        println("Solution:" +
                "\nx1 = $x1" +
                "\nx2 = $x2")
    } else if (D.absoluteValue < eps) {
        val x = (-b)/(2*a)
        println("Solution:" +
                "\nx = $x")
    } else {
        val x_x = -b / (2*b)
        val x_y = sqrt(-D)/(2*b)
        println("Solution:" +
                "\nx1 = $x_x + ${x_y}i"  +
                "\nx2 = $x_x - ${x_y}i")
    }
}