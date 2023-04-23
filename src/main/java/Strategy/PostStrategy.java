package Strategy;

import model.Post;

import java.util.List;

public interface PostStrategy {

    public List<Post> getListOfPosts(int userid);

}
