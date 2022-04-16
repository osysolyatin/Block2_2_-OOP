import kotlin.jvm.Throws

class WallService {
    private var postsArray = emptyArray<Post>()
    private var commentsArray = emptyArray<Post.Comments>()
    private var reportCommentsArray  = emptyArray<ReportCommentReasons>()
//    private var counterPostId = 0U
    @Throws(PostNotFoundException::class)
    fun getPost(_id: UInt) : Post? {
        return ((postsArray.find { it.id == _id } ?:PostNotFoundException("Такого поста нет")) as Post?)
    }

    fun add(post: Post): Post {
//        val post1 = post.copy(id = generateId())
        postsArray += post
        return postsArray.last()
    }

//    private fun generateId(): UInt {
//        counterPostId += 1U
//        return counterPostId
//    }

    fun update(post1: Post): Boolean {
        val id = post1.id
        val findPost = postsArray.find { it.id == id } ?: return false
        post1.attachment?.plus(findPost.attachment)
//        findPost.attachment?.let { post1.attachment?.addAll(it) }
        val postIndex = postsArray.indexOf(findPost)
        postsArray[postIndex] = post1.copy(id = findPost.id, ownerId = findPost.ownerId, date = findPost.date, likes = findPost.likes)
        return true
    }

    fun likeById(id: UInt): Boolean {
        for ((index, post) in postsArray.withIndex())
            if (post.id == id) {
                postsArray[index] = post.copy(likes = Post.Likes(post.likes?.count?.plus(1U) ?: 0U))
                return true
            }
        return false
    }

    @Throws(PostNotFoundException::class)
    fun createComment(comment: Post.Comments): Boolean {
        for ((index, post) in postsArray.withIndex()) {
            if (post.id == comment.postId) {
                commentsArray += comment
                postsArray[index] = post.copy(comments = comment)
                return true
            }
        }
        throw PostNotFoundException("No post with id ${comment.postId}")
//        return false
    }

    fun reportComment (_comment: Post.Comments, _reason: ReportCommentReasons) : Int {
        if (_reason in ReportCommentReasons.values()) {
            for (comment in commentsArray)
                if (_comment.commentID == comment.commentID) {
                    reportCommentsArray += _reason
                    return 1
                } else throw CommentNotFoundException("No comment with id ${comment.commentID}")
        } else throw ReasonNotFoundException("Причина не соответствует")
        return 0
    }


    fun toPrint() = buildString {
        for (post in postsArray) {
            append(post.toString())
        }
    }

    override fun toString(): String {
        return postsArray.contentToString() + '\n' + commentsArray.contentToString() + '\n'
    }
}
