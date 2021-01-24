fun main() {
    NoteService.addNote(Note(title = "Первая запись", text = "первая запись"))
    NoteService.addNote(Note(title = "Вторая запись", text = "вторая запись"))
    NoteService.addNote(Note(title = "Третья запись", text = "третья запись"))
    NoteService.addComment(Comment(text = "комментарий ко второй записи"), NoteService.getNoteById(2))

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(3)))


    NoteService.editNote(NoteService.getNoteById(1), "Первая запись отредактирована",
        "Первая запись исправлена")
    NoteService.editNote(NoteService.getNoteById(3), "Третья запись отредактирована",
        "Третья запись исправлена")

    NoteService.addComment(Comment(text = "комментарий"),
        NoteService.getNoteById(2).getCommentById(1))
    NoteService.addComment(Comment(text = "екомментарий"),
        NoteService.getNoteById(2).getCommentById(1))
    NoteService.addComment(Comment(text = "комментарий"),
        NoteService.getNoteById(2).getCommentById(1))

    NoteService.addComment(Comment(text = "комментарий"),
        NoteService.getNoteById(2).getCommentById(1).getCommentById(1))

    NoteService.editComment(NoteService.getNoteById(2).getCommentById(1),
        "комментарий ко второй записи отредактирован")
    NoteService.editComment(NoteService.getNoteById(2).getCommentById(1).getCommentById(1)
        .getCommentById(1), "комментарий отредактирован")

    println("-----После добавления и редактирования комментариев-----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(3)))

    NoteService.deleteNote(2)

    println("-----После удаления второй записи -----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    try{
        println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    } catch(e: NoteIdNotFoundException) {
        println("Вторая запись отсутствует\n")
    }
    println(NoteService.getNoteWithComments(NoteService.getNoteById(3)))

    NoteService.restoreNote(2)

    println("-----После восстановления второй записи-----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(3)))

}