package yandex

fun main() {
    val line = readLine() ?: ""
    val list = line.split(" ").map { it.toDouble() }.toMutableList()

    val a = list[0]
    val b = list[1]
    val c = list[2]

    val v0 = list[3]
    val v1 = list[4]
    val v2 = list[5]

    val dist = arrayOf(
        doubleArrayOf(0.0, a.toDouble(), b.toDouble()), // Home: to Shop, to Point
        doubleArrayOf(a.toDouble(), 0.0, c.toDouble()), // Shop: to Home, to Point
        doubleArrayOf(b.toDouble(), c.toDouble(), 0.0)  // Point: to Home, to Shop
    )

    // используем мемоизацию для ускорения
    val memo = mutableMapOf<Triple<Int, Boolean, Boolean>, Double>()

    // pos: 0 - дом, 1 - магазин, 2 - пункт
    // food: несет продукты, parcel: несет посылку
    fun dfs(pos: Int, food: Boolean, parcel: Boolean): Double {
        val key = Triple(pos, food, parcel)
        if (memo.containsKey(key)) return memo[key]!!
        // если дома и несет оба — задача решена
        if (pos == 0 && food && parcel) return 0.0
        var ans = Double.POSITIVE_INFINITY

        // можно идти в магазин, если не там
        if (pos != 1) {
            val needFood = food || pos == 1 // если уже несем или сейчас идем брать
            val needParcel = parcel
            val speed = when {
                needFood && needParcel -> v2
                needFood || needParcel -> v1
                else -> v0
            }
            // если в магазине — берем продукты
            val newFood = food || pos == 0 || pos == 2
            val step = dist[pos][1] / speed
            ans = minOf(ans, step + dfs(1, true, parcel))
        }
        // можно идти в пункт выдачи, если не там
        if (pos != 2) {
            val needFood = food
            val needParcel = parcel || pos == 2
            val speed = when {
                needFood && needParcel -> v2
                needFood || needParcel -> v1
                else -> v0
            }
            // если в пункте — берем посылку
            val newParcel = parcel || pos == 0 || pos == 1
            val step = dist[pos][2] / speed
            ans = minOf(ans, step + dfs(2, food, true))
        }
        // можно идти домой, если не дома
        if (pos != 0 && (food || parcel)) {
            val speed = when {
                food && parcel -> v2
                food || parcel -> v1
                else -> v0
            }
            val step = dist[pos][0] / speed
            ans = minOf(ans, step + dfs(0, food, parcel))
        }

        memo[key] = ans
        return ans
    }

    val answer = dfs(0, false, false)
    println("%.12f".format(answer))
}