package service;

import dao.PostDao;
import dao.UserDao;
import model.Comment;
import model.Post;
import model.User;
import utils.TimeAgo;
import utils.Validate;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CommentService {

    LoginService loginService;
    PostDao postDao;
    UserDao userDao;
    public CommentService(PostDao postDao, UserDao userDao, LoginService loginService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.loginService = loginService;
    }

    public boolean upvoteComment(String commentId, int postId){
        Optional<Post> optionalPost = postDao.getPost(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            Comment comment = getComment(commentId, post.getCommentsOnPost());
            comment.setUpvote(comment.getUpvote()+1);
            return true;
        }
        return false;
    }

    public boolean downvoteComment(String commentId, int postId){
        Optional<Post> optionalPost = postDao.getPost(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            Comment comment = getComment(commentId, post.getCommentsOnPost());
            comment.setUpvote(comment.getUpvote()-1);
            return true;
        }
        return false;
    }

    private Comment getComment(String commentId, List<Comment> commentsOnPost) {
        return commentsOnPost.stream().filter(comment -> commentId.equals(comment.getId())).findFirst().get();
    }

    public boolean replyToComment(String parentCommentId, int postId, int userId){
        Optional<Post> optionalPost = postDao.getPost(postId);
        Optional<User> optionalUser = userDao.getUser(userId);
        if(optionalPost.isPresent() && optionalUser.isPresent()){
            Post post = optionalPost.get();
            User user = optionalUser.get();

            boolean isSessionValid = Validate.validateToken(loginService.getToken(userId), user);
            if(isSessionValid){
                Comment parentComment = getComment(parentCommentId, post.getCommentsOnPost());
                Comment newComment = new Comment(UUID.randomUUID().toString(), post, user);
                parentComment.getReplies().add(newComment);
                post.getCommentsOnPost().add(newComment);
            }

            return true;
        }

        return false;
    }

}
