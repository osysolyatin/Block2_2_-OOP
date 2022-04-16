class DocumentAttachment(override val type: String = "document")  : Attachment {
    private val document : Document = Document(
        id = 1U,
        title = "Document",
        ownerId = 1U,
        userId = 1U)

    override fun toString(): String {
        return "DocumentAttachment(type='$type', document=$document)"
    }
}

class Document (
    val id: UInt = 1U,
    val title: String,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U
) {
    override fun toString(): String {
        return "DocumentAttachment(id=$id, title='$title', ownerId=$ownerId, userId=$userId)"
    }
}