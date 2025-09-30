package yandex

import java.io.File
import kotlin.math.max
import kotlin.math.min

fun main() {

    val file = File("src/main/resources/inputs/mshroomsInput.txt").readLines()
    val size = file[0].toInt()
    val list = file[1].split(" ").map { it.toInt() }.toMutableList()

    mashaSasha(size, list)


//    val file2 = File("src/main/resources/inputs/pathInput.txt").readLines()
    val line = readLine() ?: ""
    val list2 = line.split(" ").map { it.toDouble() }.toMutableList()

    findPath(list2)
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

fun findPath(list: MutableList<Double>) {
    val a = list[0]
    val b = list[1]
    val c = list[2]

    val v0 = list[3]
    val v1 = list[4]
    val v2 = list[5]

    val HSPH = (a / v0) + (c / v1) + (b / v2)

    val HPSH = (b / v0) + (c / v1) + (a / v2)

    val HSHPH = (a / v0) + (a / v1) + (b / v0) + (b / v1)

    val HPHSH = (b / v0) + (b / v1) + (a / v0) + (a / v1)

    val HPSPH = (b / v0) + (c / v1) + (c / v2) + (b / v2)

    val HSPSH = (a / v0) + (c / v1) + (c / v2) + (b / v2)

    val bad1 = (a / v0) + (a / v1) + (b / v0) + (c / v1) + (a / v2)

    val bad2 = (b / v0) + (b / v1) + (a / v0) + (c / v1) + (b / v2)

    val result = minOf(HSPH, HPSH, HSHPH, HPHSH, HPSPH, HSPSH, bad1, bad2)

    println("%.16f".format(result))
}