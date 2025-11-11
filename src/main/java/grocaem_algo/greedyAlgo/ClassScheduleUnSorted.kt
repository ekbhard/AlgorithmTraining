package grocaem_algo.greedyAlgo


fun main() {

    /**
     * передается упорядоченный список уроков и надо сделать как можно больше уроков
     */
    val scheduleList = mutableListOf<Array<Double>>()
    scheduleList.add(arrayOf(9.0, 10.0))
    scheduleList.add(arrayOf(10.0, 11.0))
    scheduleList.add(arrayOf(11.0, 12.0))
    scheduleList.add(arrayOf(9.5, 10.5))
    scheduleList.add(arrayOf(10.5, 11.5))
    scheduleList.add(arrayOf(10.2, 12.4))
    scheduleList.add(arrayOf(12.2, 13.4))
    scheduleList.add(arrayOf(15.2, 18.4))

    var checkedList = mutableListOf<Array<Double>>()
    var finalList = mutableListOf<Array<Double>>()
    finalList.add(scheduleList[0])
    checkedList.add(scheduleList[0])
    scheduleList.removeFirst()

    var temp = finalList[0]
    for (interval in scheduleList) {
        if (!checkedList.contains(interval)) {
            if (interval[0] > temp[0] && interval[1] < temp[1]) {
                checkedList.add(interval)
            } else if (interval[0] > temp[0] && interval[1] > temp[1]) {
                if (interval[0] >= temp[1]) {
                    finalList.add(interval)
                    temp = interval
                    checkedList.add(interval)
                }
            }
        }
    }

    finalList.forEach { t -> println("from " + t[0].toString() + " to " + t[1].toString()) }

}

