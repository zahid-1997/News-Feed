package dao;

import model.Post;

import java.util.*;

public class PostDao {

    Map<Integer, Post> posts;

    private PostDao(){
        this.posts = new HashMap<>();
    }

    private static Optional<PostDao> postDao = Optional.empty();
    public static PostDao getInstance(){
        if(postDao.isEmpty()){
            postDao = Optional.of(new PostDao());
        }

        return postDao.get();
    }

    public Optional<Post> getPost(int postId){
        return Optional.ofNullable(this.posts.get(postId));
    }

    public void addPost(int postId, Post post){
        posts.put(postId, post);
    }

    public int getPostsSize(){
        return this.posts.size();
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }
}
