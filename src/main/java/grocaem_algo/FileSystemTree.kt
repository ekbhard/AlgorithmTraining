package grocaem_algo

class SystemEntity(val list: List<SystemEntity>, val isFile: Boolean, val name: String) {

}

fun main() {

    val odyssey = SystemEntity(emptyList(), true, "Odyssey")
    val a = SystemEntity(emptyList(), true, "a")
    val space = SystemEntity(emptyList(), true, "space")
    val folder2011 = SystemEntity(listOf(a, space), false, "folder2011")
    val picFolder = SystemEntity(listOf(odyssey, folder2011), false, "picFolder")

    printFileSystemRecursive(picFolder)
}

fun printFileSystem(root: SystemEntity) {
    var searchDeque = ArrayDeque<SystemEntity>()
    searchDeque.add(root)
    while (searchDeque.isNotEmpty()) {
        val first = searchDeque.removeFirst()
        for (entity in first.list) {
            if (entity.isFile) {
                println("File is " + entity.name)
            } else {
                searchDeque.addLast(entity)
                println("Folder is " + entity.name)
            }
        }
    }
}

fun printFileSystemRecursive(root: SystemEntity) {
    if (root.list.isEmpty()) {
        if (root.isFile) {
            println("File is " + root.name)
            return
        }
    } else {
        println("Folder is " + root.name)
        for (entity in root.list) {
            printFileSystemRecursive(entity)
        }
    }
}