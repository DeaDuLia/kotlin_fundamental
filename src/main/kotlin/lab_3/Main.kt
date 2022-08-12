package lab_3

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Задача 3. Условный оператор + функции + перечисления + декомпозиция задачи (разбиение на подзадачи) + формальный подход.
 * На изображниях ниже (для каждого варианта свое) приводится часть координатной плоскости (−10 ≤ x ≤ 10, −10 ≤ y ≤ 10)
 * с графиками функций (парабола, линия) и фигурами (круг, прямоугольник).
 * Размер одной клетки сетки – 1 (единица).
 * Таким образом параметры функций и фигур можно однозначно определить из рисунка.
 *
 * Области, на которые разбивается плоскость графиками и контурами фигур,
 * закрашены разными цветами (белый, серый, желтый, оранжевый, голубой, зеленый).
 * Необходимо реализовать программу, которая для точки (x, y) определяет цвет области,
 * в которую данная точка попадает.
 *
 * Будем считать, что если точка (x, y) попадает на линию графика функции или контура фигуры,
 * то правильным ответом будет цвет любой соседней области.
 * Также стоит заметить,
 * что некоторые комбинации линий предполагают их пересечение за пределами изображенного на рисунке фрагмента плоскости,
 * поэтому, чтобы исключить неопределенность ответа,
 * допустимыми значениями (x, y) являются только такие, которые попадают в приведенное изображение.
 *
 * В программе должна быть реализована функция (статический метод),
 * которая для точки (x, y) возвращает цвет точки на изображении
 *
 * Вар.66 [C:\\server]
 */

enum class SimpleColor (var colorName: String) {
    Black("Black"),
    White("White"),
    Gray("Gray"),
    Red("Red"),
    Orange("Orange"),
    Yellow("Yellow"),
    Green("Green"),
    Blue("Blue")
}
val leftUpperSquare = Square(Point(-11, 11), Point(0, 11), Point(-11, 0), Point(0, 0))
val rightUpperSquare = Square(Point(0, 11), Point(11, 11), Point(0, 0), Point(11, 0))
val leftUnderSquare = Square(Point(-11, 0), Point(0, 0), Point(-11, -11), Point(0, -11))
val rightUnderSquare = Square(Point(0, 0), Point(11, 0), Point(0, -11), Point(11, -11))

val circle = Circle(Point(-8, -4), 5)
val line = Line(0, -7, -1)
val parabola = Parabola(5, -4, -0.55)

fun main () {
    val point0 = Point(0, 0) //Blue
    val point1 = Point(5, 5) //Blue
    val point2 = Point(-10, 1) //Green
    val point3 = Point(-6, 0) //Gray
    val point4 = Point(-6, -2) //White
    val point5 = Point(0, -8) //Green
    val point6 = Point(2, -10) //blue
    val point7 = Point(5, -9) //White
    val points = arrayListOf<Point>(point0, point1, point2, point3, point4, point5, point6, point7)
    println("Solution:")
    for (point in points) {
        val color = getColor(point)
        println("Point (${point.x}, ${point.y}) is ${color.colorName}")
    }
}

fun getColor(point: Point) : SimpleColor {
    if (rightUpperSquare.isPointInsideTheSquare(point)) return SimpleColor.Blue
    if (line.isPointAboveLine(point)) {
        if (circle.isPointInTheCircle(point)) return SimpleColor.Gray
        else if (parabola.isPointUnderParabolaY(point)) return SimpleColor.White
        else return SimpleColor.Blue
    } else {
        if (circle.isPointInTheCircle(point)) return SimpleColor.White
        else if (parabola.isPointUnderParabolaY(point)) return SimpleColor.Blue
        else return SimpleColor.Green
    }
}

fun getDistanceBetweenPoints (point1: Point, point2: Point) = sqrt(((point1.x-point2.x).toDouble().pow(2)) + ((point1.y-point2.y).toDouble().pow(2)))





