package service;

import Strategy.PostStrategy;
import dao.PostDao;
import dao.UserDao;
import exceptions.LoginException;
import model.Comment;
import model.Post;
import model.User;
import utils.Validate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostService {

    LoginService loginService;
    UserDao userDao;
    CommentService commentService;
    PostDao postDao;

    PostStrategy postStrategy;
    public PostService(UserDao userDao, PostDao postDao, LoginService loginService,
                       CommentService commentService, PostStrategy postStrategy){
        this.userDao = userDao;
        this.loginService = loginService;
        this.postDao = postDao;
        this.commentService = commentService;
        this.postStrategy = postStrategy;
    }

    public boolean addPost(int userId, String content) throws Exception {
        Optional<User> optionalUser = userDao.getUser(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            boolean isSessionValid = Validate.validateToken(loginService.getToken(userId), user);
            Post newPost = null;
            if(isSessionValid){
                newPost = new Post(postDao.getPostsSize()+1, content, user);
                user.getPosts().add(newPost);
            }else{
                throw new LoginException("session expied!!!");
            }
            postDao.addPost(newPost.getId(), newPost);
            return true;
        }
        return false;
    }

    public boolean upvotePost(int postId){
        Optional<Post> post = this.postDao.getPost(postId);

        if(post.isPresent()){
            post.get().setUpvote(post.get().getUpvote()+1);
            return true;
        }

        return false;
    }

    public boolean downvotePost(int postId){
        Optional<Post> post = this.postDao.getPost(postId);

        if(post.isPresent()){
            post.get().setUpvote(post.get().getUpvote()-1);
            return true;
        }

        return false;
    }

    public boolean addCommentToPost(int postId, int userId, String comment){
        Optional<Post> OptionalPost = this.postDao.getPost(postId);
        Optional<User> optionalUser = this.userDao.getUser(userId);
        if(OptionalPost.isPresent() && optionalUser.isPresent()){
            Post post = OptionalPost.get();
            User user = optionalUser.get();
            Comment com = new Comment(UUID.randomUUID().toString(), post, user);
            post.getCommentsOnPost().add(com);
        }

        return false;
    }

    public List<Post> getPosts(int userId){
        return this.postStrategy.getListOfPosts(userId);
    }

}
