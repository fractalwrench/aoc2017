fun main(args: Array<String>) {
    val resourceReader = ResourceReader()
    println(calculateValidPassphrases(resourceReader.readResource("4.txt")))
}

fun calculateValidPassphrases(input: String): Int {
    return input
            .split("\n")
            .count { isValidPassphrase(it) }
}

fun isValidPassphrase(input: String): Boolean {
    val tokens = input.split(" ")
    val hashSet = HashSet(tokens)
    return tokens.size == hashSet.size
}