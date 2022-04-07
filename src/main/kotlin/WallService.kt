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

    fun update (post1: Post) : Boolean {
        val id = post1.id
        val findPost = posts.find { it.id == id } ?: return false
        val postIndex = posts.indexOf(findPost)
        posts[postIndex] = post1.copy(ownerId = findPost.ownerId, date = findPost.date, likes = findPost.likes)
        return true
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
