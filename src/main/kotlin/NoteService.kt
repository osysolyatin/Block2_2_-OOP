class NoteService {
    var notesArray = emptyList<Notes>()


    fun notesAdd (note:Notes) : UInt {
        notesArray.plus(note)
        return note.id
    }
}