package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post extends IdGenerator{

    public Post(int id, String content, User user){
        super(id);
        this.content = content;
        this.dateOfPost = new Date();
        this.userOfPost = user;
        this.commentsOnPost = new ArrayList<>();
        this.upvote = 0;
        this.downvote = 0;
    }

    private String content;

    private User userOfPost;

    private Date dateOfPost;

    private int upvote;

    private int downvote;

    private List<Comment> commentsOnPost;

    public void setId(int id){
        super.setId(id);
    }

    public int getId(){
        return super.getId();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserOfPost() {
        return userOfPost;
    }

    public void setUserOfPost(User userOfPost) {
        this.userOfPost = userOfPost;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public List<Comment> getCommentsOnPost() {
        return commentsOnPost;
    }

    public void setCommentsOnPost(List<Comment> commentsOnPost) {
        this.commentsOnPost = commentsOnPost;
    }
}
