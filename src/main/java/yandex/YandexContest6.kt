package grocaem_algo

import java.io.File

fun main() {
    val array = File("src/main/resources/inputs/plotInput.txt").readLines()
    plotTask(array)

    socksAndShirts()
}

fun socksAndShirts() {
    val array = File("src/main/resources/inputs/socksAndShirtsInput.txt").readLines()
    val blueShirts = array[0].toInt()
    val redShirts = array[1].toInt()
    val blueSocks = array[2].toInt()
    val redSocks = array[3].toInt()

    var minRedShirts = 0
    var minBlueShirts = 0

    var minRedSocks = 0
    var minBlueSocks = 0

    if (blueShirts >= redShirts) {
        minBlueShirts = redShirts + 1
        minRedShirts = blueShirts + 1
    } else if (redShirts > blueShirts ) {
        minBlueShirts = redShirts + 1
        minRedShirts = blueShirts + 1
    }

    if (blueSocks >= redSocks) {
        minBlueSocks = redSocks + 1
        minRedSocks = blueSocks + 1
    } else if (redSocks > blueSocks ) {
        minBlueSocks = redSocks + 1
        minRedSocks = blueSocks + 1
    }

    if (minRedShirts + minRedSocks < minBlueShirts + minBlueSocks) {
        println("$minRedShirts $minRedSocks")
    } else {
        println("$minBlueShirts $minBlueSocks")
    }
}

fun findRocks() {
    val array = File("plotInput.txt").readLines()
    val J = array[0]
    val S = array[1]

    val map = mutableMapOf<Char, Int>()
    for (char in J.toCharArray()) {
        map[char] = 0
    }

    for (s in S.toCharArray()) {
        if (map.contains(s)) {
            map[s]?.let { map[s] = it.plus(1) }
        }
    }
    var result = 0

    for (entry in map) {
        result = result + entry.value
    }

    println(result)
}


fun plotTask(array: List<String>) {
    val x1 = array[0].toInt()
    val y1 = array[1].toInt()
    val x2 = array[2].toInt()
    val y2 = array[3].toInt()
    val x = array[4].toInt()
    val y = array[5].toInt()

    var place = ""

    if (x in x1..x2) {
        if (y > y2) {
            place = "N"
        }
        if (y < y1)
            place = "S"
    } else if (x > x2) {
        if (y in y1..y2) {
            place = "E"
        } else if (y > y2) {
            place = "NE"
        } else if (y < y1) {
            place = "SE"
        }
    } else if (x < x1) {
        if (y in y1..y2) {
            place = "W"
        } else if (y > y2) {
            place = "NW"
        } else if (y < y1) {
            place = "SW"
        }
    }
    println(place)
}