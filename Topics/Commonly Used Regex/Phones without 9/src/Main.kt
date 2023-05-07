import java.util.*

fun main() {
    val telephoneRegex = "((\\(([0-8]{3})\\))|([0-8]{3}))(-?)[0-8]{3}\\5[0-8]{4}".toRegex()
    val scanner = Scanner(System.`in`)
    scanner.useDelimiter("[\\s\n.]")

    while (scanner.hasNext()) {
        val str = scanner.next()
        if (str.matches(telephoneRegex)) println(str)
    }
}