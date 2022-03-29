data class Comments (
    val count: UInt, // количество комментариев
    val canPost: Boolean = false, // информация о том, может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean = false, // информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean = false, // может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean = false, // может ли текущий пользователь открыть комментарии к записи

) {
    override fun toString(): String {
        return "Comments =$count"
    }
}