
fun main(args: Array<String>) {
    val resourceReader = ResourceReader()
    println(calculateChecksum(resourceReader.readResource("2.txt")))
}

fun calculateChecksum(input: String): Int {
    return input.split("\n")
            .map { rows ->
                rows.split("\t")
                        .map { it.toInt() }
                        .sorted()
            }
            .sumBy { it.last() - it.first() }
}

class ResourceReader {
    fun readResource(name: String) = javaClass.classLoader.getResource(name).readText()
}