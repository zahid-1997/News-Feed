package controller;

import Strategy.UpvoteDownvoteStragtegy;
import model.Post;
import service.PostService;

import java.util.List;

public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    public boolean addPost(int userid, String content) throws Exception {
        return this.postService.addPost(userid, content);
    }

    public List<Post> getPosts(int userid){
        return postService.getPosts(userid);
    }

    public boolean upvote(int postId){
        return postService.upvotePost(postId);
    }

    public boolean downvote(int postId){
        return postService.downvotePost(postId);
    }

    public boolean addCommentToPost(int postId, int userId, String comment){
        return this.postService.addCommentToPost(postId, userId, comment);
    }
}
