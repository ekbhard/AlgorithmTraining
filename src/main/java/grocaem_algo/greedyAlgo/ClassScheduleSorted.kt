package grocaem_algo.greedyAlgo


fun main() {

    /**
     * передается упорядоченный список уроков и надо сделать как можно больше уроков
     */
    val scheduleList = mutableListOf<Array<Double>>()
    scheduleList.add(arrayOf(9.0, 10.0))
    scheduleList.add(arrayOf(9.5, 10.5))
    scheduleList.add(arrayOf(10.0, 11.0))
    scheduleList.add(arrayOf(10.5, 11.5))
    scheduleList.add(arrayOf(11.0, 12.0))

    var finalList = mutableListOf<Array<Double>>()

    var temp = scheduleList[0]
    finalList.add(temp)
    scheduleList.removeFirst()
    for (interval in scheduleList) {
        if (interval[0] > temp[0] && interval[1] > temp[1]) {
            if (interval[0] >= temp[1]) {
                finalList.add(interval)
                temp = interval
            }
        }
    }

    println(finalList)

}