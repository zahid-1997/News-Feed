package Strategy;

import dao.PostDao;
import model.Post;

import java.util.Collections;
import java.util.List;

public class CommentPostStrategy implements PostStrategy{

    PostDao postDao;
    public CommentPostStrategy(PostDao postDao){
        this.postDao = postDao;
    }
    @Override
    public List<Post> getListOfPosts(int userid) {
        List<Post> allPosts = postDao.getPosts();

        Collections.sort(allPosts, (post1, post2) -> {
            return  post2.getCommentsOnPost().size() - post1.getCommentsOnPost().size();
        });

        return allPosts;
    }
}
