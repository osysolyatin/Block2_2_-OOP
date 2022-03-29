data class Post(
    private val _id: UInt, // Идентификатор записи
    val ownerId: UInt, // Идентификатор владельца стены, на которой размещена запись
    val fromID: UInt, // Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: UInt, // Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора).
    // Возвращается в записях, опубликованных менее 24 часов назад.
    val date: UInt, // Время публикации записи в формате unixTime
    val text: String, // Текст записи
    val replyOwnerId: UInt, // Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: UInt, // Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = false, // true - если запись была создана с опцией «Только для друзей»
    val comments: Comments, // Информация о комментариях к записи
    val copyright: Copyright, // Источник материала
    val likes: Likes, // Информация о лайках к записи
    val reposts: Reposts, // Информация о репостах записи («Рассказать друзьям»)
    val views: Views, // Информация о просмотрах записи
    val postType: PostType = PostType.POST, // Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    val signerId: UInt, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean = false, // Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean = false, // Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean = false, // Информация о том, может ли текущий пользователь редактировать запись
    val isPinned: Boolean = false, // Информация о том, что запись закреплена
    val markedAsAds: Boolean = false, // Информация о том, содержит ли запись отметку «реклама»
    val isFavorite: Boolean = false, // true, если объект добавлен в закладки у текущего пользователя
    val donut: Donut, // Информация о записи VK Donut
    val postponedId: UInt = 0U// Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере
) {

    private var initialId: UInt = 0U
    private var id :UInt
    init {
        id = _id
    }


    private fun generateId(): UInt {
        initialId += 1U
        return initialId
    }
    internal fun getId() :UInt {
        return id
    }

    internal fun setId(postId: UInt)  {
        id = postId
    }


    override fun toString(): String {
        return "Post = 'id = $id''$text', '$likes', '$comments'"
    }
}