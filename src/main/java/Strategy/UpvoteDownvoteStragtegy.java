package Strategy;

import dao.PostDao;
import model.Post;

import java.util.Collections;
import java.util.List;

public class UpvoteDownvoteStragtegy implements PostStrategy{

    PostDao postDao;
    public UpvoteDownvoteStragtegy(PostDao postDao){
        this.postDao = postDao;
    }
    @Override
    public List<Post> getListOfPosts(int userId) {

        List<Post> allPosts = postDao.getPosts();
        Collections.sort(allPosts, (post1, post2) -> {
            int post1Diff = post1.getUpvote() - post1.getDownvote();
            int post2Diff = post2.getUpvote() - post2.getDownvote();

            return  post2Diff - post1Diff;
        });

        return allPosts;
    }
}
