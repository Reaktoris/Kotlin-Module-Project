
import kotlin.system.exitProcess

val archiveMenu = MenuHandler("Список архивов\n0. Создать архив") { exitProcess(0) }
val archiveList: MutableList<Archive> = mutableListOf()
fun main() {
    fun createArchive() {
        val archiveName = archiveMenu.stringCorrect("название архива:")
        archiveList.add(Archive())
        archiveMenu.menuList.add("${archiveMenu.controls.size}. $archiveName")
        archiveMenu.controls.add(archiveMenu.controls.size to { note(archiveList[archiveMenu.num - 1]) })
    }
    archiveMenu.start { createArchive() }
}

class Archive {
    val notesList: MutableList<Note> = mutableListOf()
}