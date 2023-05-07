fun main() {
    val pasRegex1 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\S*\$".toRegex()
    println(if (pasRegex1.matches(readln())) "Password saved" else "Password is too simple")
}