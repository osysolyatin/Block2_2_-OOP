class WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0U

    fun add (post: Post) : Post {
        val post1 = post.copy(id = generateId())
        posts += post1
        return posts.last()
    }

    private fun generateId(): UInt {
        postId += 1U
        return postId
    }

    fun update(post1: Post): Boolean {
        val postId = post1.id
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                posts[index] = post.copy(
                    ownerId = post1.ownerId,
//                    fromID = post1.fromID,
//                    createdBy = post1.createdBy,
                    date = post1.date,
                    text = post1.text,
//                    replyOwnerId = post1.replyOwnerId,
//                    replyPostId = post1.replyPostId,
//                    comments = post1.comments,
//                    copyright = post1.copyright,
//                    reposts = post1.reposts,
//                    views = post1.views,
//                    signerId = post1.signerId,
//                    canPin = post1.canPin,
//                    isPinned = post1.isPinned,
                )
                return true
            }
        }
        return false

    }


    fun likeById (id: UInt) : Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id == id){
                posts[index] = post.copy(likes = Post.Likes(post.likes.count + 1U))
                return true
            }
        return false
    }

    override fun toString(): String {
        for (post in posts) {
            println(post)
        }
        return ""
    }
}
