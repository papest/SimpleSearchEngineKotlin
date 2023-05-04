fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val key = readln()
        if (key == "stop") break
        val value = readln().toInt()
        studentsMarks.putIfAbsent(key, value)
    }
    println(studentsMarks)
}