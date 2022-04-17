enum class PostType {
    POST, COPY, REPLY, POSTPONE, SUGGEST
}

enum class EditMode {
    ALL, DURATION
}

enum class ReportCommentReasons(i: Int) {
    SPAM(0), // спам
    CHILDPORNO(1), // детская порнография
    EXTRIMISM(2), // экстремизм
    VIOLENCE(3), // насилие
    DRUGPROPOGANDA(4), // пропаганда наркотиков
    ADULTCONTENT(5), // материал для взрослых
    INSULT(6), // оскорбление
    CALLTOSUICIDE(8) // призывы к суициду
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
    var attachment: ArrayList<Attachment>?,
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

    fun addAttachment (_attachment: Attachment)  {
        this.attachment?.add(_attachment)
    }

    data class Comments (
        var commentID: UInt,
        val ownerId: Int  = 1, //Идентификатор пользователя или сообщества, на чьей стене находится запись, к которой необходимо добавить комментарий.
        val postId: UInt, //Идентификатор записи на стене
        val fromGroup: UInt = 0U, //Идентификатор сообщества, от имени которого публикуется комментарий. По умолчанию: 0
        val message: String? = "", //Текст комментария. Обязательный параметр, если не передан параметр attachments.
        val replyToComment: UInt = 0U, //Идентификатор комментария, в ответ на который должен быть добавлен новый комментарий
        val attachment: ArrayList<Attachment> = arrayListOf(), // Список объектов, приложенных к комментарию и разделённых символом «,».
        val stickerId: UInt = 0U, //Идентификатор стикера.
        val guid: String = "", //Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария.
        val count: UInt, // количество комментариев
        val canPost: Boolean = false, // информация о том, может ли текущий пользователь комментировать запись
        val groupsCanPost: Boolean = false, // информация о том, могут ли сообщества комментировать запись
        val canClose: Boolean = false, // может ли текущий пользователь закрыть комментарии к записи;
        val canOpen: Boolean = false, // может ли текущий пользователь открыть комментарии к записи

    ) {

        override fun toString(): String {
            return "Comment ID = $commentID, Comments count =$count, Text comment - $message"
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

    private fun toPrintArray(_elem : ArrayList<Attachment>) = buildString{
        for (elem in _elem) {
            append(elem.toString())
            append("\n")
        }
    }

    override fun toString(): String {
        return "Post = 'id = $id' ownerID = $ownerId '$text', '$likes', '$comments', \n" +
                "attachment(s):\n${attachment?.let { toPrintArray(it) }} \n"
    }
}