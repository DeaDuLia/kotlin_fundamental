package lab_3

import kotlin.math.pow
//y = ax^2
//a = y/x^2
class Parabola (var x0: Int, var y0 : Int, var a: Double) {
    fun isPointUnderParabolaY (point: Point) : Boolean {
        return point.y < (a * (point.x - x0).toDouble().pow(2) + y0)
    }
}