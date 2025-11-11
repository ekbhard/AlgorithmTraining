package yandex.contest8

import java.io.File
import kotlin.math.max
import kotlin.text.iterator

fun main() {

    val file = File("src/main/resources/inputs/mshroomsInput.txt").readLines()
    val size = file[0].toInt()
    val list = file[1].split(" ").map { it.toInt() }.toMutableList()

    mashaSasha(size, list)


    val file2 = File("src/main/resources/inputs/pathInput.txt").readLines()
    val list2 = file2[0].split(" ").map { it.toDouble() }.toMutableList()
//    val line = readLine() ?: ""
//    val list2 = line.split(" ").map { it.toDouble() }.toMutableList()

//    findPath(list2)

//    password()

//    val file3 = File("src/main/resources/inputs/contestInput.txt").readLines()
//    val n = file3[0].split(" ")[0].toInt()
//    val k = file3[0].split(" ")[1].toInt()
//    val list3 = file3[1].split(" ").map { it.toInt() }.toMutableList()
//
//    contest(n, k, list3)
//
//
//    val file4 = File("src/main/resources/inputs/incrementInput.txt").readLines()
//    val n4 = file4[0].split(" ")[0].toLong()
//    val k4 = file4[0].split(" ")[1].toLong()
//
//    numberIncrement(n4, k4)


    val file5 = File("src/main/resources/inputs/plusMinusInput.txt").readLines()

    val (cols, rows) = file5[0].split(" ").map { it.toInt() }

    val matrix = Array(cols) { CharArray(rows) }

    // Считываем строки с символами и заполняем матрицу
    for (i in 0 until cols) {
        val line = file5[i + 1]
        for (j in 0 until rows) {
            matrix[i][j] = line[j]
        }
    }

//    // Для проверки выведем матрицу
//    for (i in 0 until cols) {
//        for (j in 0 until rows) {
//            print(matrix[i][j])
//        }
//        println()
//    }

    plusMinus(matrix)

}

fun mashaSasha(size: Int, mushrooms: MutableList<Int>) {
    var happiness = 0
    var happinessAfterUpdate = 0

    var maxSasha = mushrooms[0]
    var minSasha = mushrooms[0]

    var indexMaxSasha = 0
    var indexMinSasha = 0

    var maxMasha = mushrooms[1]
    var minMasha = mushrooms[1]

    var indexMaxMasha = 1
    var indexMinMasha = 1

    for ((index, mushroom) in mushrooms.withIndex()) {
        if (index % 2 == 0) {
            happiness = happiness + mushroom
            if (maxSasha < mushroom) {
                maxSasha = mushroom
                indexMaxSasha = index
            }
            if (minSasha > mushroom) {
                minSasha = mushroom
                indexMinSasha = index
            }
        } else {
            happiness = happiness - mushroom
            if (maxMasha < mushroom) {
                maxMasha = mushroom
                indexMaxMasha = index
            }
            if (minMasha > mushroom) {
                minMasha = mushroom
                indexMinMasha = index
            }
        }
    }

    // попытка поменять грибы
    if (minSasha < maxMasha) {
        mushrooms[indexMinSasha] = maxMasha
        mushrooms[indexMaxMasha] = minSasha
        for ((index, mushroom) in mushrooms.withIndex()) {
            if (index % 2 == 0) {
                happinessAfterUpdate = happinessAfterUpdate + mushroom
            } else {
                happinessAfterUpdate = happinessAfterUpdate - mushroom
            }
        }
    } else if (maxSasha < minMasha) {
        mushrooms[indexMaxSasha] = minMasha
        mushrooms[indexMinMasha] = maxSasha
        for ((index, mushroom) in mushrooms.withIndex()) {
            if (index % 2 == 0) {
                happinessAfterUpdate = happinessAfterUpdate + mushroom
            } else {
                happinessAfterUpdate = happinessAfterUpdate - mushroom
            }
        }
    }

    println(max(happiness, happinessAfterUpdate))

}

fun findPath(list: List<Double>) {
    val a = list[0]
    val b = list[1]
    val c = list[2]
    val v0 = list[3]
    val v1 = list[4]
    val v2 = list[5]

    // Прямые маршруты через оба пункта
    val first = a / v0 + c / v1 + b / v2 // H -> S -> P -> H
    val second = b / v0 + c / v1 + a / v2 // H -> P -> S -> H

    // Маршруты с возвратом домой между пунктами
    val back1 = a / v0 + a / v1 + b / v0 + b / v1 // H -> S -> H -> P -> H
    val back2 = b / v0 + b / v1 + a / v0 + a / v1 // H -> P -> H -> S -> H

    // Маршруты с двойным посещением одного из пунктов
    val angle1 = a / v0 + c / v0 + c / v1 + a / v2 // H -> S -> P -> S -> H
    val angle2 = b / v0 + c / v0 + c / v1 + b / v2 // H -> P -> S -> P -> H

    val angle3 = a / v0 + c / v1 + c / v2 + a / v2 // H -> S -> P -> S -> H (с грузом)
    val angle4 = b / v0 + c / v1 + c / v2 + b / v2 // H -> P -> S -> P -> H (с грузом)

    val angle6 = b / v0 + b / v1 + b / v0 + c / v0 + c / v1 + b / v1 // H -> P -> H -> P -> S -> P -> H
    val angle7 = a / v0 + a / v1 + a / v0 + c / v0 + c / v1 + a / v1 // H -> P -> H -> P -> S -> P -> H

    // Находим минимальное время
    val result = minOf(back1, back2, first, second, angle1, angle2, angle3, angle4, angle6, angle7)

    println("%.15f".format(result))
}

fun password() {
    val s = readLine()!!
    val n = s.length

    // Считаем частоту появления каждой буквы
    val freq = mutableMapOf<Char, Long>()
    for (ch in s) {
        freq[ch] = freq.getOrDefault(ch, 0L) + 1
    }

    // Функция для вычисления сочетаний C(k, 2) = k*(k-1)/2
    fun combinations2(k: Long): Long = k * (k - 1) / 2

    // Общее количество пар позиций
    val totalPairs = combinations2(n.toLong())

    // Вычитаем пары, где буквы совпадают (не дают новых паролей)
    val sameCharPairs = freq.values.sumOf { combinations2(it) }

    // Итог
    val result = 1 + totalPairs - sameCharPairs

    println(result)
}

fun contest(n: Int, k: Int, array: MutableList<Int>) {
    val map = mutableMapOf<Int, Int>()
    val resultList = mutableListOf<Int>()
    var j = k

    for (i in array) {
        map[i] = map.getOrDefault(i, 0) + 1
    }
    while (j > 0) {
        for (key in map.keys) {
            if (resultList.size >= k) {
                break
            }
            if (map[key]!! > 0) {
                map[key] = map[key]!!.minus(1)
                resultList.add(key)
                j = j - 1
            }
        }
    }
    println(resultList.joinToString(separator = " "))
}


//fun numberIncrement(number: Long, s: Long) {
//    var sec = s
//    var num = number
//    if (num == 0L) {
//        println(num)
//        return
//    }
//    if (num.toString().last()=='0') {
//         println(num)
//        return
//    }
//    while (sec > 0) {
//        val numString = num.toString()
//        val number  = numString[numString.length - 1].toString().toLong()
//        num = num + number
//        sec = sec - 1
//    }
//    println(num)
//}

fun numberIncrement(number: Long, seconds: Long) {
    if (number.toString().last() == '0') {
        println(number.toString())
        return
    }
    val stringNum = StringBuilder(number.toString())
    for (i in seconds downTo 1) {
        val newString = increment(stringNum)
        stringNum.clear()
        stringNum.append(newString)
        if (newString.last() == '0') {
            break
        }
    }
    println(stringNum)
}

fun increment(string: StringBuilder): String {
    val resultString = string
    var isNextChanged: Boolean

    val lastNumber = string.last().toString().toLong()
    val newNumber = lastNumber + lastNumber

    if (newNumber >= 10) {
        resultString[string.length - 1] = newNumber.toString().last()
        for (i in string.length - 2 downTo 0) {
            val lastNumber = string[i].toString().toLong()
            val newNumber = lastNumber + 1
            if (newNumber < 10) {
                resultString[i] = newNumber.toString()[0]
                isNextChanged = false
            } else {
                resultString[i] = newNumber.toString().toCharArray().last()
                isNextChanged = true
            }
            if (!isNextChanged) {
                return resultString.toString()
            }
        }
        val toString = resultString.insert(0, "1").toString()
        return toString
    }
    resultString[resultString.length - 1] = newNumber.toString()[0]
    return resultString.toString()
}


fun plusMinus(matrix: Array<CharArray>) {

    val n = matrix.size
    val m = matrix[0].size

    var processedRows = mutableListOf<Int>()
    var processedCols = mutableListOf<Int>()

    for (row in matrix) {
        var result = 0
        var countQ = 0
        for (char in row) {
            if (char == '+') {
                result++
            } else if (char == '-') {
                result--
            } else if (char == '?') {
                countQ++
            }
        }
        processedRows.add(result + countQ)
    }

    for (j in 0 until m) {
//        println("----")
        var result = 0
        var countQ = 0
        for (i in 0 until n) {

            val c = matrix[i][j]
//            println(c)
            if (c == '+') {
                result++
            } else if (c == '-') {
                result--
            } else if (c == '?') {
                countQ++
            }
        }
        processedCols.add(result - countQ)
    }

    val max = processedRows.maxOrNull()!!
    val min = processedCols.minOrNull()!!

    println(max - min)
}