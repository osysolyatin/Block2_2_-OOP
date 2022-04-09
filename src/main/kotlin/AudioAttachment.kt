class AudioAttachment(override val type: String = "audio") : Attachment {
    val audio : Audio = Audio(
        id = 1U,
        albumId = 1U,
        ownerId = 1U,
        userId = 1U)

    override fun toString(): String {
        return "Audio(type='$type', audio=$audio)"
    }
}

class Audio (
    val id: UInt = 1U,
    val albumId: UInt =  1U,
    val ownerId: UInt =  1U,
    val userId: UInt =  1U
) {
    override fun toString(): String {
        return "AudioAttachment(id=$id, albumId=$albumId, ownerId=$ownerId, userId=$userId)"
    }

}