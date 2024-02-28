import java.util.Scanner

class MenuHandler (val name: String, val back: () -> Unit){
    var controls = mutableListOf("0" to {})
    val menuList: MutableList<String> = mutableListOf()
    val scanner: Scanner = Scanner(System.`in`)
    var num: String = ""
    fun start(create: () -> Unit) {
        controls[0] = "0" to create
        printMenu()
        input()
    }

    fun printMenu() {
        println(name)
        for (i in menuList) println(i)
        println("${controls.size}. Выход")
    }

    fun input() {
        while (true) {
            val input = intCorrect()
            for (i in controls) {
                if (i.first == input) {num = i.first; i.second(); printMenu(); break}
                else if (controls.size.toString() == input) back()
            }
        }
    }

    fun stringCorrect(text: String): String {
        println("Введите $text")
        return scanner.nextLine()
    }

    fun intCorrect(): String {
        return scanner.nextLine()
    }

}