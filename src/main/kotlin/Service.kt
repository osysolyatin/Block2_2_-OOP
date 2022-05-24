class Service <T> {

    var notesList = mutableListOf <T>()
    var commentsList = mutableListOf <T>()

    fun add (data: T) {
        notesList.add(data)
    }

    fun createComment(comment: T): Boolean {
        commentsList.add(comment)
        return true
        }

    fun deleteComment (comment: T) : UInt {
        commentsList.find { comment == commentsList}
        return 1U
    }
}

