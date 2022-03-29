class WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1U

    fun add (post: Post) : Post {
        post.setId(postId)
        posts += post
        postId++
        return posts.last()
    }

//    private fun generateId(): UInt {
//        initialPostID += 1U
//        return initialPostID
//    }

//    fun update(post: Post): Boolean {
//        val postId = post.component1()
//        val post1 = post
//        for ((index, post) in posts.withIndex()) {
//            if (post.id == postId) {
//                posts[index] = post.copy(
//                    fromId = post1.fromId,
//                    createdBy = post1.createdBy,
//                    text = post1.text,
//                    replyOwnerId = post1.replyOwnerId,
//                    replyPostId = post1.replyPostId,
//                    friendsOnly = post1.friendsOnly,
//                    comments = post1.comments,
//                    copyright = post1.copyright,
//                    likes = post1.likes,
//                    reposts = post1.reposts,
//                    views = post1.views,
//                    postType = post1.postType,
//                    signerId = post1.signerId,
//                    canPin = post1.canPin,
//                    canDelete = post1.canDelete,
//                    canEdit = post1.canEdit,
//                    isPinned = post1.isPinned,
//                    markedAsAds = post1.markedAsAds,
//                    isFavorite = post1.isFavorite,
//                    postponedId = post1.postponedId
//                )
////                println(posts[index])
//                return true
//            }
//        }
//        return false
//
//    }


    fun likeById (id: UInt) : Boolean {
        for ((index, post) in posts.withIndex())
            if (post.getId() == id){
                posts[index] = post.copy(likes = Likes(post.likes.count+1U), _id = id)
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
