package yandex_algo

fun main() {

    println(averageWaitingTime(arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(4, 3))))
//    println(averageWaitingTime(arrayOf(intArrayOf(5, 2), intArrayOf(2, 5), intArrayOf(4, 3))))
}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var currentTime = 0
    var array = mutableListOf<Int>()

    for (customer in customers) {
        val arrival = customer[0]
        val time = customer[1]
        if (currentTime > arrival) {
            currentTime += currentTime - arrival
        }
        currentTime += time
        array.add(currentTime - arrival)
    }

    return array.sum().toDouble() / array.size
}