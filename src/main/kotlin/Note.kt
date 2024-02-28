val notesMenu = MenuHandler("Список заметок\n0. Создать заметку") { main() }

fun note(notes: Archive) {
    fun createNote() {
        val noteName = notesMenu.stringCorrect("название заметки:")
        notes.notesList.add(Note())
        notesMenu.menuList.add("${notesMenu.controls.size}. $noteName")
        notesMenu.controls.add(notesMenu.controls.size.toString() to { writeNote(notes.notesList[notesMenu.num.toInt() - 1]) })
    }
    notesMenu.start { createNote() }
}

class Note() {
    var noteText: String = ""
}