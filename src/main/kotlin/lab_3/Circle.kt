package lab_3

class Circle (var centerPoint: Point, var radius: Int) {
    fun isPointInTheCircle (point: Point) : Boolean {
        val distance = getDistanceBetweenPoints(centerPoint, point)
        return distance < radius
    }

}