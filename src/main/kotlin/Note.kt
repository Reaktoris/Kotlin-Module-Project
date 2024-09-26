

fun note(archive: Archive) {
    fun createNote() {
        val noteName = archive.notesMenu.stringCorrect("название заметки:")
        val noteText = archive.notesMenu.stringCorrect("текст заметки:")
        archive.notesList.add(Note(noteText))
        archive.notesMenu.menuList.add("${archive.notesMenu.controls.size}. $noteName")
        archive.notesMenu.controls.add(archive.notesMenu.controls.size to { writeNote(archive.notesList[archive.notesMenu.num - 1]) })
    }
    archive.notesMenu.start { createNote() }
}

class Note (var noteText: String){
}