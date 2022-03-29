import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun likeById() {
        // arrange
        val id = 1U
        val service = WallService()
        val post = Post(
//            id = 1U,
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
        service.add(post)

        //act
        val result = service.likeById(id)

        //assert
        assertEquals(true,result)
    }
}