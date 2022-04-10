data class VideoAttachment(override val type: String = "video") : Attachment {

    private val video : Video = Video(
        id = 1U,
        albumId = 1U,
        ownerId = 1U,
        userId = 1U)

    override fun toString(): String {
        return "VideoAttachment(type='$type', video=$video)"
    }
}

class Video (
    val id: UInt = 1U,
    val albumId: UInt =  1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U
) {
    override fun toString(): String {
        return "VideoAttachment(id=$id, albumId=$albumId, ownerId=$ownerId, userId=$userId)"
    }

}