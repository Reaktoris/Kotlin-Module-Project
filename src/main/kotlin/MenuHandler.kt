import java.util.Scanner

class MenuHandler (val name: String, val back: () -> Unit){
    var controls = mutableListOf(0 to {})
    val menuList: MutableList<String> = mutableListOf()
    val scanner: Scanner = Scanner(System.`in`)
    var num: Int = 0
    fun start(create: () -> Unit) {
        controls[0] = 0 to create
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
                else if (controls.size == input) back()
                else if (controls.size < input) println("Такого пункта меню нет. Введите корректное значение:")
            }
        }
    }

    fun stringCorrect(text: String): String {
        println("Введите $text")
        return scanner.next()
    }

    fun intCorrect(): Int {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt()
            } else {
                println("Введите корректное значение:")
                scanner.next()
            }
        }
    }

}