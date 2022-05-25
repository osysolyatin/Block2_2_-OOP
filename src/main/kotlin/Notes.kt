enum class Privacy {
    ALL, ONLY_FRIENDS, FRIENDS_OF_FRIENDS, ONLY_USER
}

data class Notes (
    val id : UInt,
    val title : String,
    val text : String,
    val privacy: Privacy,
        )
{

    data class Comments (
        val commentId : UInt,
        val noteId : UInt,
        val message : String,
        val privacy: Privacy,
            ) {
        var isDeleted: Boolean = false
    }
}