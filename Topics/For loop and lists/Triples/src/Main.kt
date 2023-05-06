fun readInt(): Int = readln().toInt()
@SuppressWarnings("MagicNumber")
fun main() {
    val size = readInt()
    var tripleCount = 0
    if (size < 3) {
        println(0)
        return
    }
    var first = readInt()
    var second = readInt()
    var third: Int
    for (i in 2 until size) {
        third = readInt()
        if (third - first == 2 && second == first + 1) tripleCount++
        first = second
        second = third
    }
    println(tripleCount)
}