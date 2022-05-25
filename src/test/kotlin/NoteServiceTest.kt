import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        // arrange
        val noteService = NoteService()
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        //act
        val result = noteService.add(note1)

        // assert
        assertTrue(result)
    }

    @Test
    fun createCommentTrue() {
        // arrange
        val noteService = NoteService()
        val comment1 = Notes.Comments (
            commentId = 1U,
            noteId = 1U,
            message = "Первый комментарий",
            privacy = Privacy.ALL
        )
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        noteService.add(note1)

        // act

        val result = noteService.createComment(comment1)

        //assert

        assertTrue(result)
    }

    @Test (expected = PostNotFoundException::class)
    fun createCommentShouldThrow() {
        // arrange
        val noteService = NoteService()
        val comment1 = Notes.Comments (
            commentId = 1U,
            noteId = 2U,
            message = "Первый комментарий",
            privacy = Privacy.ALL
        )
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        noteService.add(note1)

        // act

        noteService.createComment(comment1)


    }

    @Test
    fun deleteCommentTrue() {
        // arrange
        val noteService = NoteService()
        val comment1 = Notes.Comments (
            commentId = 1U,
            noteId = 1U,
            message = "Первый комментарий",
            privacy = Privacy.ALL
        )
        val comment2 = Notes.Comments (
            commentId = 2U,
            noteId = 1U,
            message = "Второй комментарий",
            privacy = Privacy.ALL
        )
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        noteService.add(note1)
        noteService.createComment(comment1)
        noteService.createComment(comment2)

        // act

        val result = noteService.deleteComment(1U)

        //assert

        assertTrue(result)
    }

    @Test
    fun deleteCommentFalse() {
        // arrange
        val noteService = NoteService()
        val comment1 = Notes.Comments (
            commentId = 1U,
            noteId = 1U,
            message = "Первый комментарий",
            privacy = Privacy.ALL
        )

        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        noteService.add(note1)
        noteService.createComment(comment1)


        // act

        val result = noteService.deleteComment(2U)

        //assert

        assertFalse(result)
    }

    @Test
    fun removeTrue() {
        // arrange
        val noteService = NoteService()
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )

        noteService.add(note1)

        // act

        val result = noteService.remove(1U)

        //assert

        assertTrue(result)
    }

    @Test
    fun removeFalse() {
        // arrange
        val noteService = NoteService()
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )

        noteService.add(note1)

        // act

        val result = noteService.remove(3U)

        //assert

        assertFalse(result)
    }

    @Test
    fun updateTrue() {
        // arrange
        val noteService = NoteService()
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        val updatedNote = Notes (
            id = 1U,
            title = "First Changed Note",
            text = "Это моя измененная Заметка",
            privacy = Privacy.ALL,
        )

        noteService.add(note1)

        // act

        val result = noteService.update(updatedNote)

        //assert

        assertTrue(result)
    }
    @Test
    fun updateFalse() {
        // arrange
        val noteService = NoteService()
        val note1 = Notes (
            id = 1U,
            title = "First Note",
            text = "Это моя первая Заметка",
            privacy = Privacy.ALL,
        )
        val updatedNote = Notes (
            id = 2U,
            title = "First Changed Note",
            text = "Это моя измененная Заметка",
            privacy = Privacy.ALL,
        )

        noteService.add(note1)

        // act

        val result = noteService.update(updatedNote)

        //assert

        assertFalse(result)
    }
}