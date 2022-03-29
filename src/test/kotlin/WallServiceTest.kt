import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun likeById() {
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
    fun updateTrue() {
        // arrange
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
        val result = service.update(post)

        //assert
        assertEquals(true,result)

    }

    @Test
    fun updateFalse() {
        // arrange
        val service = WallService()
        val post = Post(
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
        service.add(post)

        //act
        val result = service.update(post)

        //assert
        assertEquals(false,result)

    }
}