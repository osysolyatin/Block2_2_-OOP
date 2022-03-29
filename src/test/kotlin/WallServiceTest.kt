import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun likeByIdTrue() {
        // arrange
        val id = 1U
        val service = WallService()
        val post = Post(
            id = 1U,
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
            signerId = 0U,
            canPin = true,
            isPinned = true,
            donut = Post.Donut(editMode = EditMode.DURATION),
        )
        service.add(post)

        //act
        val result = service.likeById(id)

        //assert
        assertEquals(true,result)
    }

    @Test
    fun likeByIdFalse() {
        // arrange
        val id = 4U
        val service = WallService()
        val post = Post(
            id = 1U,
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
            signerId = 0U,
            canPin = true,
            isPinned = true,
            donut = Post.Donut(editMode = EditMode.DURATION),
        )
        service.add(post)

        //act
        val result = service.likeById(id)

        //assert
        assertEquals(false,result)
    }

    @Test
    fun updateTrue() {
        // arrange
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
            signerId = 0U,
            canPin = true,
            isPinned = true,
            donut = Post.Donut(editMode = EditMode.DURATION),
        )
        service.add(post1)
        service.add(post2)

        //act
        val result = service.update(post2)

        //assert
        assertEquals(true,result)

    }

    @Test
    fun updateFalse() {
        // arrange
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
            signerId = 0U,
            canPin = true,
            isPinned = true,
            donut = Post.Donut(editMode = EditMode.DURATION),
        )
        service.add(post1)
        service.add(post2)

        //act
        val result = service.update(post2)

        //assert
        assertEquals(false,result)

    }
}