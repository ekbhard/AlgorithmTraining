package yandex

fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }

    var currentN = n
    var remainingK = k

    // Если k = 0, выводим n
    if (remainingK == 0L) {
        println(currentN)
        return
    }

    val seenDigits = mutableMapOf<Long, Long>()
    val path = mutableListOf<Long>()

    while (remainingK > 0) {
        val lastDigit = currentN % 10

        // Нашли цикл
        if (seenDigits.containsKey(lastDigit)) {
            val startIndex = seenDigits[lastDigit]!!
            val cycleLength = path.size - startIndex
            val cycleSum = currentN - path[startIndex.toInt()]

            val fullCycles = remainingK / cycleLength
            currentN += fullCycles * cycleSum
            remainingK %= cycleLength

            // Выходим из основного цикла, чтобы выполнить оставшиеся шаги
            break
        }

        seenDigits[lastDigit] = path.size.toLong()
        path.add(currentN)

        currentN += lastDigit
        remainingK--
    }

    // Если цикл был найден, выполняем оставшиеся шаги
    for (i in 0 until remainingK.toInt()) {
        currentN += currentN % 10
    }

    println(currentN)
}
