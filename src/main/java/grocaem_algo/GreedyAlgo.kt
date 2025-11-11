package grocaem_algo


fun main() {
    // Список штатов
    val statesNeeded: MutableSet<String> = HashSet(
        listOf(
            "mt", "wa", "or", "id",
            "nv", "ut", "ca", "az"
        )
    )

    /* Список станций. Ключи - названия станций, а значения - сокращенные
    обозначения штатов, входящих в зону охвата */
    val stations: MutableMap<String, Set<String>> = LinkedHashMap()
    stations["kone"] = HashSet(listOf("id", "nv", "ut"))
    stations["ktwo"] = HashSet(listOf("wa", "id", "mt"))
    stations["kthree"] = HashSet(listOf("or", "nv", "ca"))
    stations["kfour"] = HashSet(listOf("nv", "ut"))
    stations["kfive"] = HashSet(listOf("ca", "az"))

    // Итоговый набор станций
    val finalStations: MutableSet<String> = HashSet()

    while (statesNeeded.isNotEmpty()) {
        var bestStation: String? = null
        var statesCovered = mutableSetOf<String>()
        for ((station, states) in stations) {
            val covered = statesNeeded intersect states
            if (covered.size > statesCovered.size) {
                bestStation = station
                statesCovered = covered as MutableSet<String>
            }
        }
        statesNeeded -= statesCovered
        if (bestStation != null) {
            finalStations.add(bestStation)
        }
    }

    println(finalStations) // [ktwo, kone, kthree, kfive]
}