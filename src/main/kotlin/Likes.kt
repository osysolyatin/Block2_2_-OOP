data class Likes(
    var count: UInt, // число пользователей, которым понравилась запись
    val userLikes: Boolean = false, // наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean = false, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean = false // информация о том, может ли текущий пользователь сделать репост записи
) {
    override fun toString(): String {
        return "Likes =$count"
    }
}
