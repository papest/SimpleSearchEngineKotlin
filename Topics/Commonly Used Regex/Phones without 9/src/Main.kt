fun main() {
    val telephoneRegex = "((\\(([0-8]{3})\\))|([0-8]{3}))(-?)[0-8]{3}\\5[0-8]{4}".toRegex()
    telephoneRegex.findAll(readln()).forEach { println(it.value) }
}