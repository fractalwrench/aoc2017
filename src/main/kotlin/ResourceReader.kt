class ResourceReader {
    fun readResource(name: String) = javaClass.classLoader.getResource(name).readText()
}