data class Notes (
    val id : UInt,
    val title : String,
    val text : String,

        )
{
    val privacy : Array<Int> = arrayOf(0,1,2,3)
    // 0 — все пользователи,
    // 1 — только друзья,
    // 2 — друзья и друзья друзей,
    // 3 — только пользователь.

    val commentPrivacy : Array<Int> = arrayOf(0,1,2,3)

    data class Comments (
        val commentId : UInt,
        val noteId : UInt
            ) {
        val isDeleted: Boolean = false


    }
}