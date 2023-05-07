fun main() {
    val nameRegex = "\\b[A-Z][a-z]*(\\s[A-Z][a-z]*)?".toRegex()
    nameRegex.findAll(readln()).forEach { println(it.value) }
}