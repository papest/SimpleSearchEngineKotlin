fun main() {
    val text = readln()
    "\\S*(pa)+\\S*".toRegex().findAll(text).forEach { println(it.value) }
}