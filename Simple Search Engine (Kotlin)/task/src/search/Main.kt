package search

const val ENTER_NUMBER_OF_LINES = "Enter the number of people:"
const val ENTER_ALL_LINES = "Enter all people:"
const val ENTER_NUMBER_OF_QUERIES = "Enter the number of search queries:"
const val ENTER_SEARCH_DATA = "Enter data to search people:"
const val RESULT = "People found:"
const val NOT_FOUND = "No matching people found."

fun expandedSearch() {
    val size: Int = ENTER_NUMBER_OF_LINES.answer().toInt()
    val lines = ENTER_ALL_LINES.answer(size)
    val countOfQuery = ENTER_NUMBER_OF_QUERIES.answer().toInt()

    repeat(countOfQuery) {
        val searchData = ENTER_SEARCH_DATA.answer()
        val result = lines.filter { it.replace("\\s".toRegex(), "").contains(searchData, true) }
        if (result.isEmpty()) {
            println(NOT_FOUND)
        } else {
            println(RESULT)
            result.forEach { println(it) }
        }
    }

}

fun String.answer() = also { println(it) }.run { readln() }

fun String.answer(number: Int) = also { println(it) }.run { List(number) { readln() } }

fun main() {
    expandedSearch()
}
