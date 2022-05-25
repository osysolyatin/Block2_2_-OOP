import org.junit.Test
import org.junit.Assert.*

class WallNoteServiceTest {

    @Test
    fun likeByIdTrue() {
        // arrange
        val id = 1U
        val service = WallService()
        val post = Post(
            id = 1U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = id, count = 78U, commentID = 0U),
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
        service.add(post)

        //act
        val result = service.likeById(id)

        //assert
        assertTrue(result)
    }

    @Test
    fun likeByIdFalse() {
        // arrange
        val id = 4U
        val service = WallService()
        val post = Post(
            id = 1U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = id, count = 78U, commentID = 0U),
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
        service.add(post)

        //act
        val result = service.likeById(id)

        //assert
        assertFalse(result)
    }

    @Test
    fun updateTrue() {
        // arrange
        val service = WallService()
        val post1 = Post(
            id = 0U,
            ownerId = 1U,
            fromID = 0U,
            createdBy = 77U,
            date = 5844558U,
            text = "Это мой первый пост",
            replyOwnerId = 1U,
            replyPostId = 67U,
            friendsOnly = true,
            comments = Post.Comments(
                postId = 0U,
                count = 22U,
                canPost = true,
                groupsCanPost = false,
                canClose = true,
                canOpen = true,
                commentID = 0U
            ),
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
            id = 1U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = 1U, count = 78U, commentID = 0U),
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
            id = 1U,
            ownerId = 4U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Второй пост - Измененный",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = 1U, count = 78U, commentID = 0U),
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
        service.add(post1)
        service.add(post2)

        //act
        val result = service.update(updatePostText)

        //assert
        assertTrue(result)

    }

    @Test
    fun updateFalse() {
        // arrange
        val service = WallService()
        val post1 = Post(
            id = 0U,
            ownerId = 1U,
            fromID = 0U,
            createdBy = 77U,
            date = 5844558U,
            text = "Это мой первый пост",
            replyOwnerId = 1U,
            replyPostId = 67U,
            friendsOnly = true,
            comments = Post.Comments(
                postId = 0U,
                count = 22U,
                canPost = true,
                groupsCanPost = false,
                canClose = true,
                canOpen = true,
                commentID = 0U
            ),
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
            id = 3U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = 3U, count = 78U, commentID = 0U),
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
            id = 4U,
            ownerId = 4U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Второй пост - Измененный",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(postId = 4U, count = 78U, commentID = 0U),
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
        service.add(post1)
        service.add(post2)

        //act
        val result = service.update(updatePostText)

        //assert
        assertFalse(result)

    }

    @Test
    fun createCommentTrue() {
        // arrange
        val service = WallService()
        val comment1 = Post.Comments(
            commentID = 1U,
            postId = 1U,
            message = "Первый комментарий",
            count = 76U
        )
        val post1 = Post(
            id = 1U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(count = 78U, postId = 2U, commentID = 1U),
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
        service.add(post1)

        // act

        val result = service.createComment(comment1)

        //assert

        assertTrue(result)

    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentShouldThrow() {
        // arrange
        val service = WallService()
        val comment1 = Post.Comments(
            commentID = 1U,
            postId = 4U,
            message = "Первый комментарий",
            count = 76U
        )
        val post1 = Post(
            id = 1U,
            ownerId = 2U,
            fromID = 1U,
            createdBy = 78U,
            date = 7844555U,
            text = "Это мой второй пост",
            replyOwnerId = 2U,
            replyPostId = 78U,
            comments = Post.Comments(count = 78U, postId = 2U, commentID = 1U),
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
        service.add(post1)

        // act

        service.createComment(comment1)

    }

    @Test
    fun reportComment() {
        // arrange
        val service = WallService()
        val post1 = Post(
            id = 1U,
            ownerId = 1U,
            fromID = 0U,
            createdBy = 77U,
            date = 5844558U,
            text = "Это мой первый пост",
            replyOwnerId = 1U,
            replyPostId = 67U,
            friendsOnly = true,
            comments = Post.Comments(
                postId = 0U,
                count = 22U,
                canPost = true,
                groupsCanPost = false,
                canClose = true,
                canOpen = true,
                commentID = 0U
            ),
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

        val comment1 = Post.Comments(
            commentID = 1U,
            postId = 1U,
            message = "Первый комментарий",
            count = 76U
        )
        service.add(post1)
        service.createComment(comment1)

        val reason = ReportCommentReasons.ADULTCONTENT

        // act

        val result = service.reportComment(comment1, reason)
        //        println(reportCommentsArray.contentToString())

        // assert

        assertEquals(1, result)
    }


    @Test(expected = CommentNotFoundException::class)
    fun reportCommentNotFound() {
        // arrange
        val service = WallService()
        val post1 = Post(
            id = 1U,
            ownerId = 1U,
            fromID = 0U,
            createdBy = 77U,
            date = 5844558U,
            text = "Это мой первый пост",
            replyOwnerId = 1U,
            replyPostId = 67U,
            friendsOnly = true,
            comments = Post.Comments(
                postId = 0U,
                count = 22U,
                canPost = true,
                groupsCanPost = false,
                canClose = true,
                canOpen = true,
                commentID = 0U
            ),
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

        val comment1 = Post.Comments(
            commentID = 1U,
            postId = 1U,
            message = "Первый комментарий",
            count = 76U
        )
        service.add(post1)
//    service.createComment(comment1)

        val reason = ReportCommentReasons.ADULTCONTENT

        // act

        service.reportComment(comment1, reason)

    }
}
