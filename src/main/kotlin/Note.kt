val notesMenu = MenuHandler("Список заметок\n0. Создать заметку") { main() }

fun note(notes: Archive) {
    fun createNote() {
        val noteName = notesMenu.stringCorrect("название заметки:")
        val noteText = notesMenu.stringCorrect("Введите текст заметки:")
        notes.notesList.add(Note(noteText))
        notesMenu.menuList.add("${notesMenu.controls.size}. $noteName")
        notesMenu.controls.add(notesMenu.controls.size to { writeNote(notes.notesList[notesMenu.num - 1]) })
    }
    notesMenu.start { createNote() }
}

class Note (var noteText: String){
}