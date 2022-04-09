
fun main() {
    val service = WallService()
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
        comments = Post.Comments(count = 22U, canPost = true, groupsCanPost = false, canClose = true, canOpen = true),
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
        comments = Post.Comments(count = 78U),
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

    val updatePostText = Post(
        id =2U,
        ownerId =   4U,
        fromID = 1U,
        createdBy = 78U,
        date = 7844555U,
        text = "Второй пост - Измененный",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Post.Comments(count = 78U),
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

    val videoAttachment = VideoAttachment()
    val audioAttachment = AudioAttachment()
    val noteAttachment = NoteAttachment()
    val photoAttachment = PhotoAttachment()
    val documentAttachment = DocumentAttachment()

    post1.addAttachment(videoAttachment)
    post1.addAttachment(documentAttachment)
    post1.addAttachment(noteAttachment)

    post2.addAttachment(audioAttachment)
    post2.addAttachment(photoAttachment)

    updatePostText.addAttachment(noteAttachment)



    println("attachment - ${post1.attachment?.size}")
    println("Post 1 attachment ${post1.attachment.toString()}")
    println("Post 2 attachment ${post2.attachment.toString()}")

    service.add(post1)
    service.add(post2)

    println("Вывод первоначальных постов")
    println(service)
    service.likeById(2U)
    println("Вывод постов после лайка")
    println(service)
    service.update(updatePostText)
    println("Вывод значений после изменения поста")
    println(service)



}