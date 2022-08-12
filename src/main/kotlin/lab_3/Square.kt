package lab_3

class Square (var leftUpperPoint: Point, var rightUpperPoint: Point, var leftUnderPoint: Point, var rightUnderPoint: Point) {
    fun isPointInsideTheSquare (point: Point) : Boolean {
        return point.x > leftUpperPoint.x && point.y < leftUpperPoint.y
                && point.x < rightUnderPoint.x && point.y > rightUnderPoint.y
    }
}