class NoteService: Service <Notes, Notes.Comments> {

    private var notesList = mutableListOf <Notes>()
    private var commentsList = mutableListOf <Notes.Comments>()

    override fun add (date: Notes):Boolean {
        notesList.add(date)
        return true
    }

    override fun createComment(comment: Notes.Comments): Boolean {

        for (note in notesList) {
            if (note.id == comment.noteId) {
                commentsList.add(comment)
                return true
            }
        }
        throw PostNotFoundException ("No notes with id ${comment.noteId}")
    }

    override fun deleteComment (commentId: UInt) : Boolean {
        val comment = commentsList.find {it.commentId == commentId} ?: return false
        comment.isDeleted = true
        return true
    }

    override fun remove(noteId: UInt) : Boolean {
        if(notesList.removeIf { it.id == noteId }) return true
        return false

    }

    override fun update(date: Notes) :Boolean {
        val findNoteId = date.id
        return if (notesList.contains(notesList.find { it.id == findNoteId })) {
            notesList[notesList.indexOf(notesList.find { it.id == findNoteId })] = date
            true
        } else false
        //val findNote = notesList.find { it.id == findNoteId }
        //val findNoteIndex = notesList.indexOf(findNote)
        //notesList[findNoteIndex] = date
        //notesList[notesList.indexOf(notesList.find { it.id == findNoteId })] = date
        //return true
        // notesList.replaceAll { (findNote) -> date }
    }

    fun toPrint() {
        notesList.forEachIndexed { index, notes ->
            println("Заметка № ${index+1} : $notes")
            println("Комментарии: ")
            commentsList.forEach { comments ->
                if (notes.id == comments.noteId && !comments.isDeleted) println("$comments")
            }
            println()
        }
    }

}

