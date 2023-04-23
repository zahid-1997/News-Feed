package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

    private String id;

    private Date dateOfComment;

    private User commentedUser;

    private Post commentedOnPost;

    private int upvoteComment;

    private int downvoteComment;

    private List<Comment> replies;

    public Comment(String id, Post post, User user) {
        this.dateOfComment = new Date();
        this.upvoteComment = 0;
        this.downvoteComment = 0;
        this.replies = new ArrayList<>();
        this.commentedOnPost = post;
        this.commentedUser = user;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.getId();
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public User getCommentedUser() {
        return commentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        this.commentedUser = commentedUser;
    }

    public Post getCommentedOnPost() {
        return commentedOnPost;
    }

    public void setCommentedOnPost(Post commentedOnPost) {
        this.commentedOnPost = commentedOnPost;
    }

    public int getUpvote() {
        return upvoteComment;
    }

    public void setUpvote(int upvote) {
        this.upvoteComment = upvote;
    }

    public int getDownvote() {
        return downvoteComment;
    }

    public void setDownvote(int downvote) {
        this.downvoteComment = downvote;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
}
