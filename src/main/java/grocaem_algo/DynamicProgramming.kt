package grocaem_algo

//class Item(val name: String, val weight: Int, val price: Int)
//
//class BackPack(var items: MutableList<Item>) {
//    fun getBackPackCost(): Int {
//        return items.map { item -> item.price }.sumOf { it }
//    }
//}

fun main() {
    /**
     * задача на то что можно украсть в магазине
     *
     * в рюкзак вмещается 4 фунта
     * есть гитара 1 фунт - 1500$
     * ноутбук 3 фунта - 2000$
     * магнитофон 4 фунта - 3000$
     * айфон 1 фунт - 2000$
     *
     * задача узнать как впихнуть как можно больше
     */

    //размер рюкзака
    var n = 4
    val items = arrayListOf(
        Item("гитара", 1, 1500),
        Item("ноутбук", 3, 2000),
        Item("магнитофон", 4, 3000),
    )
    //количество вещей
    val k = items.size

    val matrix: Array<Array<BackPack?>> = Array(n + 1) { arrayOfNulls(k + 1) }

    //row
    for (weight in 1..n) {
        //col
        for (itemIndex in 0 until k) {
            val currentBackPack = BackPack(mutableSetOf())
            val currentItem = items[itemIndex]
            if (currentItem.weight <= weight) {
                val freeWeight = weight - currentItem.weight
                val backPackWithMaxCost = matrix[freeWeight][k - 1]
                if (freeWeight > 0) {
                    if (backPackWithMaxCost != null) {
                        backPackWithMaxCost.items.forEach { item ->
                            if (item != currentItem) {
                                currentBackPack.items.add(item)
                            }
                        }
                    }
                }
                currentBackPack.items.add(currentItem)
                if (itemIndex != 0 && currentBackPack.getBackPackCost() >= (matrix[weight][itemIndex - 1]?.getBackPackCost() ?: 0)
                ) {
                    matrix[weight][itemIndex] = currentBackPack
                } else if (itemIndex != 0) {
                    matrix[weight][itemIndex] = matrix[weight][itemIndex - 1]
                } else matrix[weight][itemIndex] = currentBackPack
            } else {
                matrix[weight][itemIndex] = matrix[weight][itemIndex - 1]
            }
        }
    }

}