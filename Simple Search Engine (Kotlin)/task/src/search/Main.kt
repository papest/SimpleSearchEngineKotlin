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
const val SELECT_STRATEGY = "Select a matching strategy: ALL, ANY, NONE"

enum class Strategy {
    ALL,
    ANY,
    NONE
}

fun searchWords(
    dataSearch: String,
    strategy: Strategy,
    lines: List<String>,
    invertedIndexMap: MutableMap<String, MutableSet<Int>>
): MutableSet<String> {
    var result = mutableSetOf<String>()
    val dataSearchList = dataSearch.split("\\s".toRegex())
    when (strategy) {
        Strategy.ANY -> {
            dataSearchList.forEach { word ->
                result.addAll((invertedIndexMap[word] ?: mutableSetOf()).toList().map { lines[it] })
            }
        }
        Strategy.NONE -> {
            result.addAll(lines)
            dataSearchList.forEach { it ->
                result.removeAll((invertedIndexMap[it] ?: mutableSetOf()).map { lines[it] }.toSet())
            }
        }
        Strategy.ALL -> {
            dataSearchList.forEach { it ->
                val res = (invertedIndexMap[it] ?: mutableSetOf()).map { lines[it] }
                if (res.isEmpty()) return result
                result = if (result.isEmpty()) res.toMutableSet() else result.intersect(res.toSet()).toMutableSet()
            }
        }
    }
    return result
}

fun searchDialog(lines: List<String>, invertedIndexMap: MutableMap<String, MutableSet<Int>>) {
    val strategy: Strategy = Strategy.valueOf(SELECT_STRATEGY.answer())
    val searchData = ENTER_SEARCH_DATA.answer().lowercase()
    val result = searchWords(searchData, strategy, lines, invertedIndexMap)
    if (result.isEmpty()) {
        println(NOT_FOUND)
    } else {
        println(RESULT)
        result.forEach { println(it) }
    }
}

fun menu(lines: List<String>, invertedIndexMap: MutableMap<String, MutableSet<Int>>) {
    while (true) {
        println(MENU_TEXT)
        when (readln()) {
            "1" -> searchDialog(lines, invertedIndexMap)
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
    val invertedIndexMap = mutableMapOf<String, MutableSet<Int>>()
    lines.indices.forEach {
        for (word in lines[it].lowercase().split("\\s+".toRegex())) {
            if (invertedIndexMap.contains(word)) {
                invertedIndexMap[word]?.add(it)
            } else {
                invertedIndexMap[word] = mutableSetOf(it)
            }
        }
    }
    menu(lines, invertedIndexMap)
    println("Bye!")
}

fun String.answer() = also { println(it) }.run { readln() }

fun main(args: Array<String>) {
    expandedSearch(args[1])
}
