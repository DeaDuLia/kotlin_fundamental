package lab_3

class Line (var x0: Int, var y0: Int, var a: Int) {
    fun isPointAboveLine (point: Point) : Boolean {
        return point.y > a * (point.x - x0) + y0
    }
}