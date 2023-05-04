package search

fun main() {
    val words : List<String> = readln().split(" ")
    val searchWord = readln()
    val index = words.indexOf(searchWord) + 1
    println(if (index == 0) "Not Found" else index)
}
