data class Reposts(
    val count: UInt, // число пользователей, скопировавших запись
    val userReposted: Boolean = false // наличие репоста от текущего пользователя
)
