import kotlin.jvm.Throws

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Post.Comments>()
    private var reportComments = emptyArray<ReportCommentReasons>()
    private var counterId = 0U

    fun add(post: Post): Post {
        val post1 = post.copy(id = generateId())
        posts += post1
        return posts.last()
    }

    private fun generateId(): UInt {
        counterId += 1U
        return counterId
    }

    fun update(post1: Post): Boolean {
        val id = post1.id
        val findPost = posts.find { it.id == id } ?: return false
        findPost.attachment?.let { post1.attachment?.addAll(it) }
        val postIndex = posts.indexOf(findPost)

        posts[postIndex] = post1.copy(ownerId = findPost.ownerId, date = findPost.date, likes = findPost.likes)
        return true
    }

    fun likeById(id: UInt): Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id == id) {
                posts[index] = post.copy(likes = Post.Likes(post.likes?.count?.plus(1U) ?: 0U))
                return true
            }
        return false
    }

    @Throws(PostNotFoundException::class)
    fun createComment(comment: Post.Comments): Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id == comment.postId) {
                comment.commentID = generateId()
                comments += comment
                posts[index] = post.copy(comments = comment)
                return true
            } else throw PostNotFoundException("No post with id ${comment.postId}")
        return false
    }

    fun reportComment (_comment: Post.Comments, _reason: ReportCommentReasons) : Int {
        if (_reason in ReportCommentReasons.values()) {
            for (comment in comments)
                if (_comment.commentID == comment.commentID) {
                    reportComments += _reason
                    return 1
                } else throw CommentNotFoundException("No comment with id ${comment.commentID}")
        } else throw ReasonNotFoundException("Причина не соответствует")
        return 0
    }


    fun toPrint() = buildString {
        for (post in posts) {
            append(post.toString())
        }
    }

    override fun toString(): String {
        return posts.contentToString() + '\n' + comments.contentToString() + '\n'
    }
}
