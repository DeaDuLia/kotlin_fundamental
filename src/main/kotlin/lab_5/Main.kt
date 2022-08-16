package lab_5

import kotlin.math.abs
import kotlin.math.sign

/**
 * Задача 5. Вложенные циклы. Простые алгоритмы.
 * Напечать в консоле следующие фигуры.
 * Для печати реализовать отдельныю функциюс параметрами.
 * Для различных вариантов могут быть заданы следующие параметры:
 * h – высота фигуры
 * w – ширина фигыры
 * s – размер фигуры
 * Для каждого варианта указаны допустимые значения данных параметров,
 * а также в скобках приведены значения параметров для приведенного примера.
 *
 * Вар. 27
 * w и h >= 5, w и h — нечетные (в примере ниже: w = 13, h = 9) j-w/2 i-h/2
*-----*
|     |
|     |
|     |
*-----*-----*
      |     |
      |     |
      |     |
      *-----*
 */
fun main () {
      //printFigure()
      //printFigure2()
      printFigure3()
}
//ver1
fun printFigure (w: Int = 13, h: Int = 9) {
      for (i in 0 until h) {
            for (j in 0 until w) {
                  if (i == 0) {
                        if (j == 0 || j == w/2) print("*")
                        else if (j < w/2) print("-")
                  } else if (i == h-1) {
                        if (j == w-1 || j == w/2) print("*")
                        else if (j > w/2) print("-")
                        else print(" ")
                  } else if (i == h/2) {
                        if (j == w-1 || j == w/2 || j == 0) print("*")
                        else print("-")
                  } else {
                        if (i < h/2 && j == 0
                              || j == w/2
                              || i > h/2 && j == w-1
                        ) print("/")
                        else print(" ")
                  }
            }
            println()
      }
}
//ver2
fun printFigure2 (w: Int = 13, h: Int = 9) {
      for (i in 0 until h) {
            for (j in 0 until w) {
                  if (kotlin.math.abs(sign((w/2 - j).toDouble()) - sign((h/2 - i).toDouble())) <= 1) {
                        if (j == 0 || j == w/2 || j == w-1) {
                              if (i == 0 || i == h / 2 || i == h - 1) print("*")
                              else print("/")
                        } else if (i == 0 || i == h/2 || i == h-1) {
                              print("-")
                        } else {
                              print(" ")
                        }
                  } else {
                        print(" ")
                  }
            }
            println()
      }
}
//ver3. Compact
fun printFigure3 (w: Int = 13, h: Int = 9) {
      for (i in 0 until h) {
            for (j in 0 until w) {
                  if (abs(sign((w/2 - j).toDouble()) - sign((h/2 - i).toDouble())) > 1 ||
                        abs(w/2-j) > 0 && abs(w/2-j) < w/2 && (i != 0 && i != h/2 && i != h-1)) {
                        print(" ")
                  } else if (j == 0 || j == w/2 || j == w-1){
                        print(if (i == 0 || i == h / 2 || i == h - 1) "*" else "/")
                  } else {
                        print("-")
                  }
            }
            println()
      }
}

fun printFigure4 (w: Int = 13, h: Int = 9) {
      for (i in 0 until h) {
            for (j in 0 until w) {
                  if (abs(sign((w/2 - j).toDouble()) - sign((h/2 - i).toDouble())) > 1 ||
                        abs(w/2-j) > 0 && abs(w/2-j) < w/2 && (i != 0 && i != h/2 && i != h-1)) {
                        print(" ")
                  } else if (j == 0 || j == w/2 || j == w-1) print(if (i == 0 || i == h / 2 || i == h - 1) "*" else "/")
                  else print("-")
            }
            println()
      }
}






