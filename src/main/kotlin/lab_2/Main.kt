package lab_2

import java.lang.Exception
import kotlin.math.*

enum class Location(val description: String) {
    TWO_INTERSECTIONS("These circles have two intersections"),
    INNER_INTERSECTION("These circles have one inner intersection"),
    OUTER_INTERSECTION("These circles have one outer intersection"),
    NO_ONE_INTERSECTIONS_AND_INSCRIBED("These circles have no one intersections, inscribed"),
    NO_ONE_INTERSECTIONS_AND_NOT_INSCRIBED("These circles have no one intersections, not inscribed")
}

fun main () {
    /**
     * Задача 2. Условный оператор. Функции.
     * Для ввода данных, вычислений и вывода данных использовать отдельные функции (методы).
     * Не использовать глобальные переменные,
     * все необходимые данные передавать в эти функции (методы).
     *
     *
     * Вар. 11
     *
     * Даны две окружности, заданные в виде координат центра (X, Y) и радиуса R.
     * Проверить их взаимное расположение (варианты: пересекаются в 2-х точках,
     * касаются (1 общая точка) с внешней стороны, касаются (1 общая точка) с внутренней стороны,
     * не пересекаются не вписаны одна в другую, не пересекаются одна окружность вписана в другую).
     * При сравнении на равенство вещественных чисел использовать сравнение с заданной точностью (e – константа).
     */

    var circle1 = createCircle()
    var circle2 = createCircle()
    var location = getCirclesLocation(circle1, circle2)
    println("Solution:" +
            "\nLocation - ${location.name}, ${location.description}")

}
val EPS = 0.00000001
fun createCircle () :Circle {
    val x : Double? = readLine()?.toDouble()
    val y : Double?  = readLine()?.toDoubleOrNull()
    val radius : Double?  = readLine()?.toDoubleOrNull()
    println("Creating Circle: (x=$x, y=$y), R=$radius")
    if (x != null && y != null && radius != null) {
        return Circle(Point(x,y), radius)
    }
    throw Exception("Values enter error!!!");
}

fun getCirclesLocation (circle1: Circle, circle2: Circle) : Location {
    val distance = getDistanceBetweenPoints(circle1.centerPoint, circle2.centerPoint)
    val maxRadius = max(circle1.radius, circle2.radius)
    val minRadius = min(circle1.radius, circle2.radius)
    if (distance <= maxRadius) {
        if (distance+minRadius > maxRadius) return Location.TWO_INTERSECTIONS
        if (distance+minRadius < maxRadius) return Location.NO_ONE_INTERSECTIONS_AND_INSCRIBED
        if (abs(distance+minRadius - maxRadius) < EPS) return Location.INNER_INTERSECTION
    } else {
        if (distance - (minRadius + maxRadius) < 0) return Location.TWO_INTERSECTIONS
        if (distance - (minRadius + maxRadius) > 0) return Location.NO_ONE_INTERSECTIONS_AND_NOT_INSCRIBED
        if (abs(distance - (minRadius + maxRadius)) < EPS) return Location.OUTER_INTERSECTION
    }
    throw Exception("ERROR")
}

fun getDistanceBetweenPoints (point1: Point, point2: Point) = sqrt(((point1.x-point2.x).toDouble().pow(2)) + ((point1.y-point2.y).toDouble().pow(2)))


