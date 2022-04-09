class NoteAttachment(override val type: String = "note") : Attachment {
    val note : Note =Note(
        id = 1U,
        ownerId = 1U,
        userId = 1U,
        text = "записка",
        date = 46468856U)
}

class Note (
    val id: UInt = 1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U,
    val text: String,
    val date: UInt
) {

}