class PhotoAttachment(override val type: String = "photo") : Attachment {
    private val photo : Photo = Photo(
        id = 1U,
        ownerId = 1U,
        userId = 1U,
        text = "фото",
        date = 46468856U)

    override fun toString(): String {
        return "PhotoAttachment(type='$type', photo=$photo)"
    }
}

class Photo (
    val id: UInt = 1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U,
    val text: String,
    val date: UInt
) {
    override fun toString(): String {
        return "Photo(id=$id, ownerId=$ownerId, userId=$userId, text='$text', date=$date)"
    }

}