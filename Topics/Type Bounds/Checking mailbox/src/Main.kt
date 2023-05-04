class Letter
class CherryPie
class MailBox<T : Letter>(var value: T) {

    fun sendLetter() {
        println("Letter is sent!")
    }
}