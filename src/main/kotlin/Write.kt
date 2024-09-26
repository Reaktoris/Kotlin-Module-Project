val noteMenu = MenuHandler("0. Посмотреть заметку\n1. Изменить заметку") { note(archiveList[archiveMenu.num - 1]) }

fun writeNote(note: Note) {
    noteMenu.controls = mutableListOf(0 to {}, 1 to {
        note.noteText = noteMenu.stringCorrect("текст заметки:")
    })
    fun openNote() = println(note.noteText)
    noteMenu.start { openNote() }
}