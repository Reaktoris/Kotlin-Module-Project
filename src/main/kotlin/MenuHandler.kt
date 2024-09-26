import java.util.Scanner

class MenuHandler (val name: String, val back: () -> Unit){
    var controls = mutableListOf(0 to {})
    val menuList: MutableList<String> = mutableListOf()
    val scanner1: Scanner = Scanner(System.`in`)
    val scanner2: Scanner = Scanner(System.`in`)
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
                else if (controls.size < input || input < 0) {
                    println("Такого пункта меню нет. Введите корректное значение:")
                    input()
                }
            }
        }
    }

    fun stringCorrect(text: String): String {
        println("Введите $text")
        while (true) {
            val s2 = scanner2.nextLine()
            if (s2.replace(" ", "").isEmpty()) {
                println("Введите корректное значение:")
            } else {
                return s2
            }
        }
    }

    fun intCorrect(): Int {
        while (true) {
            if (scanner1.hasNextInt()) {
                return scanner1.nextInt()
            } else {
                scanner1.next()
                println("Введите корректное значение:")
            }
        }
    }

}