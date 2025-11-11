package grocaem_algo

class Item(val name: String, val weight: Int, val price: Int)

class BackPack(var items: MutableSet<Item>) {
    fun getBackPackCost(): Int {
        return items.map { item -> item.price }.sumOf { it }
    }
}

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
    val items = arrayListOf(
        Item("гитара", 1, 1500),
        Item("ноутбук", 3, 2000),
        Item("магнитофон", 4, 3000),
    )

    //количество вещей
    var n = items.size

    //размер рюкзака
    val k = 4

    var matrix = Array(n) { arrayOfNulls<BackPack?>(k + 1) }


    for ((index, item) in items.withIndex()) {
        for (weight in 0..k) {
            var backPack: BackPack? = BackPack(mutableSetOf())
            if (weight == 0) {
                matrix[index][weight] = BackPack(mutableSetOf())
            } else if (index == 0) {
                matrix[index][weight] = BackPack(mutableSetOf(items[0]))
            } else {
                if (item.weight <= weight) {
                    backPack?.items?.add(item)
                    val freeWeight = weight - item.weight
                    if (freeWeight > 0) {
                        var prevPackPack = matrix[index - 1][freeWeight]
                        if (prevPackPack != null) {
                            backPack?.items?.addAll(prevPackPack.items)
                        }
                    }
                    val prevMax = matrix[index - 1][weight]
                    if ((prevMax?.getBackPackCost() ?: 0) > (backPack?.getBackPackCost() ?: 0)) {
                        backPack = matrix[index - 1][weight]
                    }
                } else {
                    backPack = matrix[index - 1][weight]
                }
                matrix[index][weight] = backPack
            }
        }
    }
}