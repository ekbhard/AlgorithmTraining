package grocaem_algo


fun main() {
    var graph = mutableMapOf<String, MutableMap<String, Int>>()

    graph.put("Start", mutableMapOf("A" to 6, "B" to 2))

    graph.put("A", mutableMapOf("End" to 1))
    graph.put("B", mutableMapOf("End" to 5, "A" to 3))
    graph.put("End", mutableMapOf())

    var costs = mutableMapOf<String, Int>()
    costs.put("A", 6)
    costs.put("B", 2)
    costs.put("End", Integer.MAX_VALUE)

    var parents = mutableMapOf<String, String>()
    parents.put("A", "Start")
    parents.put("B", "Start")
    parents.put("End", "")


    val dijkstra = dijkstra(graph, costs, parents)

}

fun dijkstra(graph: Map<String, Map<String, Int>>,
             costs: MutableMap<String, Int>,
             parents: MutableMap<String, String>):
        Pair<Int, List<String>> {

    var processed = mutableSetOf<String>()
    var node = findLowestCostNode(costs, processed)

    // Основной цикл: пока есть необработанные узлы
    while (node != null) {
        var cost = costs[node] ?: continue
        var neighbors = graph[node] ?: emptyMap()

        // Итерируемся по всем соседям текущего узла
        for ((neighbor, weight) in neighbors) {
            val newCost = cost + weight
            // Если новый путь до соседа короче, чем существующий
            if (newCost < (costs[neighbor] ?: Int.MAX_VALUE)) {
                // Обновляем стоимость
                costs[neighbor] = newCost
                // Обновляем родителя
                parents[neighbor] = node
            }
        }

        // Помечаем узел как обработанный
        processed.add(node)

        // Находим следующий необработанный узел с наименьшей стоимостью
        node = findLowestCostNode(costs, processed)
    }

    // Восстановление пути
    val shortestPath = mutableListOf<String>()
    var current = "End"
    while (current != "Start") {
        shortestPath.add(0, current) // Добавляем в начало списка
        val parent = parents[current] ?: break
        current = parent
    }
    shortestPath.add(0, "Start")

    val finalCost = costs["End"] ?: -1
    return Pair(finalCost, shortestPath)
}

fun findLowestCostNode(costs: Map<String, Int>, processed: Set<String>): String? {
    var lowestCost = Int.MAX_VALUE
    var lowestCostNode: String? = null
    for ((node, cost) in costs) {
        if (cost < lowestCost && node !in processed) {
            lowestCost = cost
            lowestCostNode = node
        }
    }
    return lowestCostNode
}