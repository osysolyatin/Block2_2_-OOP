interface Service <N,C> {

    fun add (date :N) :Boolean
    fun createComment (comment: C) :Boolean
    fun deleteComment (commentId: UInt) : Boolean
    fun remove (noteId: UInt): Boolean
    fun update (date: N) : Boolean

}