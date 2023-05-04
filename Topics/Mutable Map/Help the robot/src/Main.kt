fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
    val result = mutableMapOf<String, Int>()
    result.putAll(purchases)
    addition.forEach { (key, value) ->
        result[key] = value + (result[key] ?: 0)
    }
    return result
}
