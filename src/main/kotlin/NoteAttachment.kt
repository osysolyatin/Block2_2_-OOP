class NoteAttachment(override val type: String = "note") : Attachment {
    private val note : Note =Note(
        id = 1U,
        ownerId = 1U,
        userId = 1U,
        text = "записка",
        date = 46468856U)

    override fun toString(): String {
        return "NoteAttachment(type='$type', note=$note)"
    }
}

class Note (
    val id: UInt = 1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U,
    val text: String,
    val date: UInt
) {
    override fun toString(): String {
        return "Note(id=$id, ownerId=$ownerId, userId=$userId, text='$text', date=$date)"
    }

}