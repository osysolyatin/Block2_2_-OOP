class PhotoAttachment(override val type: String = "photo") : Attachment {
    val photo : Photo = Photo(
        id = 1U,
        ownerId = 1U,
        userId = 1U,
        text = "фото",
        date = 46468856U)
}

class Photo (
    val id: UInt = 1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U,
    val text: String,
    val date: UInt
) {

}