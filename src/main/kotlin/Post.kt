enum class PostType {
    POST, COPY, REPLY, POSTPONE, SUGGEST
}

enum class EditMode {
    ALL, DURATION
}

data class Post(
    val id: UInt, // Идентификатор записи
    val ownerId: UInt, // Идентификатор владельца стены, на которой размещена запись
    val fromID: UInt, // Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: UInt, // Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора).
    // Возвращается в записях, опубликованных менее 24 часов назад.
    val date: UInt, // Время публикации записи в формате unixTime
    var text: String?, // Текст записи
    val replyOwnerId: UInt, // Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: UInt, // Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = false, // true - если запись была создана с опцией «Только для друзей»
    val comments: Comments?, // Информация о комментариях к записи
    val copyright: Copyright?, // Источник материала
    val likes: Likes?, // Информация о лайках к записи
    val reposts: Reposts?, // Информация о репостах записи («Рассказать друзьям»)
    val views: Views?, // Информация о просмотрах записи
    val postType: PostType = PostType.POST, // Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
    val signerId: UInt?, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean = false, // Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean = false, // Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean = false, // Информация о том, может ли текущий пользователь редактировать запись
    val isPinned: Boolean = false, // Информация о том, что запись закреплена
    val markedAsAds: Boolean = false, // Информация о том, содержит ли запись отметку «реклама»
    val isFavorite: Boolean = false, // true, если объект добавлен в закладки у текущего пользователя
    val donut: Donut?, // Информация о записи VK Donut
    val postponedId: UInt? = 0U// Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере, val id: kotlin.UInt){}
) {
    var attachment = arrayOfNulls<Attachment>(5)
        set(value) {
            field += value
        }

//    fun addAttachment (_attachment: Attachment) : Attachment {
//        attachment = attachment.plus(_attachment)
//        return attachment.last() ?: _attachment
//    }


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

    data class Copyright(
        val id: UInt,
        val link: String,
        val name: String,
        val type: String
    )

    data class Likes(
        var count: UInt = 0U, // число пользователей, которым понравилась запись
        val userLikes: Boolean = false, // наличие отметки «Мне нравится» от текущего пользователя
        val canLike: Boolean = false, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
        val canPublish: Boolean = false // информация о том, может ли текущий пользователь сделать репост записи
    ) {
        override fun toString(): String {
            return "Likes =$count"
        }
    }

    data class Reposts(
        val count: UInt, // число пользователей, скопировавших запись
        val userReposted: Boolean = false // наличие репоста от текущего пользователя
    )

    data class Views(
        val count: UInt // число просмотров записи
    )

    data class Donut(
        val isDonut: Boolean = false, // запись доступна только платным подписчикам VK Donut
        val paidDuration: UInt = 60U, // время, в течение которого запись будет доступна только платным подписчикам VK Donut
        val placeholder: Any = Any(), // заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
        val canPublishFreeCopy: Boolean = false, // можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
        val editMode: EditMode = EditMode.ALL// информация о том, какие значения VK Donut можно изменить в записи
    )


    override fun toString(): String {
        return "Post = 'id = $id' ownerID = $ownerId '$text', '$likes', '$comments', attachment - ${attachment.contentToString()}"
    }
}