package Strategy;

import dao.PostDao;
import model.Post;

import java.util.Collections;
import java.util.List;

public class TimeStampPostStrategy implements PostStrategy{

    PostDao postDao;
    public TimeStampPostStrategy(PostDao postDao){
        this.postDao = postDao;
    }

    @Override
    public List<Post> getListOfPosts(int userId) {
        List<Post> allPosts = postDao.getPosts();
        Collections.sort(allPosts, (post1, post2) -> {
            return post2.getDateOfPost().compareTo(post1.getDateOfPost());
        });

        return allPosts;
    }
}
