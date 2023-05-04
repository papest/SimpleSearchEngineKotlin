package search

import java.io.File

const val ENTER_SEARCH_DATA = "Enter a name or email to search all suitable people."
const val RESULT = "People found:"
const val NOT_FOUND = "No matching people found."
const val MENU_TEXT = """=== Menu ===
1. Find a person
2. Print all people
0. Exit"""
const val TITLE_OF_LIST = "=== List of people ==="
const val INCORRECT_OPTION = "Incorrect option! Try again."

fun searchDialog(lines: List<String>) {
    val searchData = ENTER_SEARCH_DATA.answer()
    val result = lines.filter { it.replace("\\s".toRegex(), "").contains(searchData, true) }
    if (result.isEmpty()) {
        println(NOT_FOUND)
    } else {
        println(RESULT)
        result.forEach { println(it) }
    }
}

fun menu(lines: List<String>) {
    while (true) {
        println(MENU_TEXT)
        when (readln()) {
            "1" -> searchDialog(lines)
            "2" -> printAll(lines)
            "0" -> break
            else -> println(INCORRECT_OPTION)
        }
    }
}

fun printAll(lines: List<String>) {
    println(TITLE_OF_LIST)
    println(lines.joinToString("\n"))
}

fun expandedSearch(filePath: String) {
    val file = File(filePath)
    val lines = file.readLines()
    menu(lines)
    println("Bye!")
}

fun String.answer() = also { println(it) }.run { readln() }

fun main(args: Array<String>) {
    expandedSearch(args[1])
}
