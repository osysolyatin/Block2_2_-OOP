fun main() {
    val service = WallService()
    val post1 = Post(
        _id = 0U,
        ownerId =   1U,
        fromID = 0U,
        createdBy = 77U,
        date = 5844558U,
        text = "Это мой первый пост",
        replyOwnerId = 1U,
        replyPostId = 67U,
        friendsOnly = true,
        comments = Comments(count = 22U,canPost = true, groupsCanPost = false, canClose = true, canOpen = true ),
        copyright = Copyright(id = 777U, "www.netology.ru", "Нетология", "web"),
        likes = Likes(count = 22U, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(count = 5U, userReposted = false),
        views = Views(count = 125U),
        postType = PostType.POST,
        signerId = 0U,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut(isDonut = false, paidDuration = 5421U, placeholder = Any(), canPublishFreeCopy = true, editMode = EditMode.ALL),
        postponedId = 25U
    )

    val post2 = Post(
        _id = 0U,
        ownerId =   2U,
        fromID = 1U,
        createdBy = 78U,
        date = 7844555U,
        text = "Это мой второй пост",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Comments(count = 78U),
        copyright = Copyright(id = 178U, "www.vk.com", "ВКонтакте", "social network"),
        likes = Likes(count = 98U),
        reposts = Reposts(count = 155U, userReposted = true),
        views = Views(count = 198U),
        signerId = 0U,
        canPin = true,
        isPinned = true,
        donut = Donut(editMode = EditMode.DURATION),
    )

    service.add(post1)
    service.add(post2)
    service.likeById(2U)
    println(service)

    val updatePostId = 1U
    var updatePostText = Post(
        _id = 2U,
        ownerId =   2U,
        fromID = 1U,
        createdBy = 78U,
        date = 7844555U,
        text = "Измененный пост",
        replyOwnerId = 2U,
        replyPostId = 78U,
        comments = Comments(count = 78U),
        copyright = Copyright(id = 178U, "www.vk.com", "ВКонтакте", "social network"),
        likes = Likes(count = 98U),
        reposts = Reposts(count = 155U, userReposted = true),
        views = Views(count = 198U),
        signerId = 0U,
        canPin = true,
        isPinned = true,
        donut = Donut(editMode = EditMode.DURATION),)

}