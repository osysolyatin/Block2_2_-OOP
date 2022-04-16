
fun main() {
    val service = WallService()
    var counterId = 0U

    fun generateId(): UInt {
        counterId += 1U
        return counterId
    }
    val post1 = Post(
        id = 0U,
        ownerId =   1U,
        fromID = 0U,
        createdBy = 77U,
        date = 5844558U,
        text = "Это мой первый пост",
        replyOwnerId = 1U,
        replyPostId = 67U,
        friendsOnly = true,
        comments = Post.Comments(postId = 0U, count = 22U, canPost = true, groupsCanPost = false, canClose = true, canOpen = true, commentID = 0U),
        copyright = Post.Copyright(id = 777U, "www.netology.ru", "Нетология", "web"),
        likes = Post.Likes(count = 22U, userLikes = true, canLike = true, canPublish = true),
        reposts = Post.Reposts(count = 5U, userReposted = false),
        views = Post.Views(count = 125U),
        postType = PostType.POST,
        attachment = arrayListOf(),
        signerId = 0U,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Post.Donut(
            isDonut = false,
            paidDuration = 5421U,
            placeholder = Any(),
            canPublishFreeCopy = true,
            editMode = EditMode.ALL
        ),
        postponedId = 25U,

    )

    val post2 = Post(
        id = 0U,
        ownerId =   2U,
        fromID = 1U,
        createdBy = 78U,
        date = 7844555U,
        text = "Это мой второй пост",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Post.Comments(count = 78U, postId = 2U, commentID = 0U),
        copyright = Post.Copyright(id = 178U, "www.vk.com", "ВКонтакте", "social network"),
        likes = Post.Likes(count = 98U),
        reposts = Post.Reposts(count = 155U, userReposted = true),
        views = Post.Views(count = 198U),
        attachment = arrayListOf(),
        signerId = 0U,
        canPin = true,
        isPinned = true,
        donut = Post.Donut(editMode = EditMode.DURATION),

    )

    val post3 = Post(
        id = 0U,
        ownerId =   3U,
        fromID = 1U,
        createdBy = 77U,
        date = 784476775U,
        text = "Это мой третий пост",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Post.Comments(count = 0U, postId = 2U, commentID = 0U),
        copyright = Post.Copyright(id = 178U, "www.facebook.com", "Facebook", "social network"),
        likes = Post.Likes(count = 0U),
        reposts = Post.Reposts(count = 155U, userReposted = true),
        views = Post.Views(count = 198U),
        attachment = arrayListOf(),
        signerId = 0U,
        canPin = true,
        isPinned = true,
        donut = Post.Donut(editMode = EditMode.DURATION),

        )

    // Добавляем посты на стену

    service.add(post1)
    service.add(post2)
    service.add(post3)

    println("Вывод первоначальных постов: \n")
    println(service.toPrint())

    // Добавляем лайк к посту с id:2 (post2)

    service.likeById(2U)
    service.likeById(3U)
    println("Вывод постов после лайка: \n")
    println(service.toPrint())

    // Вносим изменения в пост.
    // Будем вносить изменения в пост с id=2.

    val updatePostText = Post(
        id =2U,
        ownerId =   4U,
        fromID = 1U,
        createdBy = 78U,
        date = 7844555U,
        text = "Второй пост - Измененный",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Post.Comments(postId = 2U, count = 78U, commentID = 0U),
        copyright = Post.Copyright(id = 178U, "www.vk.com", "ВКонтакте", "social network"),
        likes = Post.Likes(count = 0U),
        reposts = Post.Reposts(count = 155U, userReposted = true),
        views = Post.Views(count = 198U),
        attachment = arrayListOf(),
        signerId = 0U,
        canPin = true,
        isPinned = true,
        donut = Post.Donut(editMode = EditMode.DURATION),
    )

    service.update(updatePostText)
    println("Вывод значений после изменения поста: \n")
    println(service.toPrint())

    // Создаем объекты - attachments

    val videoAttachment = VideoAttachment()
    val audioAttachment = AudioAttachment()
    val noteAttachment = NoteAttachment()
    val photoAttachment = PhotoAttachment()
    val documentAttachment = DocumentAttachment()

    // Добавляем аттачменты к постам

    post1.addAttachment(videoAttachment)
    post1.addAttachment(documentAttachment)
    post1.addAttachment(noteAttachment)

    post2.addAttachment(audioAttachment)
    post2.addAttachment(photoAttachment)

    post3.addAttachment(noteAttachment)

    println("Вывод постов после аттачментов:")
    println(service.toPrint())

    updatePostText.addAttachment(noteAttachment)
    updatePostText.addAttachment(documentAttachment)
    println("Вывод постов после изменения поста с аттачментом:")
    println(service.toPrint())

    // Создаем объекты - комментарий к посту с id=1.

    val comment1 = Post.Comments(
        commentID = generateId(),
        postId = 1U,
        message = "Первый комментарий",
        count = 76U
    )
    val comment2 = Post.Comments(
        commentID = generateId(),
        postId = 2U,
        message = "Второй комментарий",
        count = 45U
    )
    val comment3 = Post.Comments(
        commentID = generateId(),
        postId = 3U,
        message = "Третий комментарий",
        count = 1U
    )

    service.createComment(comment1)
    service.createComment(comment2)
    service.createComment(comment3)

    println("comment1 commentId = ${comment1.commentID}")
    println("comment2 commentId = ${comment2.commentID}")
    println("comment3 commentId = ${comment3.commentID}")
    println("Вывод постов после комментария: \n")
    println(service.toPrint())

}