package Strategy;

import dao.PostDao;
import model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FollowerPostStrategy implements PostStrategy{

    PostDao postDao;
    public FollowerPostStrategy(PostDao postDao){
        this.postDao = postDao;
    }

    @Override
    public List<Post> getListOfPosts(int userId) {
        List<Post> allPosts = postDao.getPosts();
        return allPosts.stream().filter(post -> post.getUserOfPost().getId()==userId).collect(Collectors.toList());
    }
}
