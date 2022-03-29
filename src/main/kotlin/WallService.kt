class WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0U

    @Suppress("NAME_SHADOWING")
    fun add (post: Post) : Post {
        val post = post.copy(id = generateId())
        posts += post
        return posts.last()
    }

    private fun generateId(): UInt {
        postId += 1U
        return postId
    }

    @Suppress("NAME_SHADOWING")
    fun update(post: Post): Boolean {
        val postId = post.component1()
        val postChanged = post
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                posts[index] = post.copy(
                    ownerId = postChanged.ownerId,
                    fromID = postChanged.fromID,
                    createdBy = postChanged.createdBy,
                    date = postChanged.date,
                    text = postChanged.text,
                    replyOwnerId = postChanged.replyOwnerId,
                    replyPostId = postChanged.replyPostId,
                    comments = postChanged.comments,
                    copyright = postChanged.copyright,
                    reposts = postChanged.reposts,
                    views = postChanged.views,
                    signerId = postChanged.signerId,
                    canPin = postChanged.canPin,
                    isPinned = postChanged.isPinned,
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
             println(post.toString())
        }
        return ""
    }
}
