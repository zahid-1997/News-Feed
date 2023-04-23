package controller;

import service.CommentService;

public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    public boolean upvoteComment(String commentId, int postId){
        return commentService.upvoteComment(commentId, postId);
    }

    public boolean downvoteComment(String commentId, int postId){
        return commentService.downvoteComment(commentId, postId);
    }

    public boolean replyToComment(String parentCommentId, int postId, int userid){
        return commentService.replyToComment(parentCommentId, postId, userid);
    }
}
