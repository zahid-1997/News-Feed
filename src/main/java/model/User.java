package model;

import exceptions.RegistrationException;

import java.util.ArrayList;
import java.util.List;

public class User extends IdGenerator{

    private String name;

    private String username;

    private String password;

    private String emailAddress;

    private List<Integer> followers;

    private List<Integer> following;

    private List<Post> posts;

    private User(int id){
        super(id);
    }
    private static UserBuilder userBuilder;

    public static UserBuilder getInstance(){
        if(userBuilder == null)
            userBuilder = new UserBuilder();

        return userBuilder;
    }

    public static class UserBuilder {

        private int id;

        private String name;

        private String username;

        private String password;

        private String emailAddress;

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setUsername(String username){
            this.username = username;
            return this;
        }

        public UserBuilder setEmailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder setId(int id){
            this.id = id;
            return this;
        }

        public User build() throws RegistrationException {
            if(this.username == null){
                throw new RegistrationException("Username should be set");
            }else if(this.password == null){
                throw new RegistrationException("Password must be set");
            }else if(this.emailAddress == null){
                throw new RegistrationException("email is compulsory");
            }

            User user = new User(this.id);
            user.setName(this.name);
            user.setEmailAddress(this.emailAddress);
            user.setUsername(this.username);
            user.setPassword(this.password);
            user.setFollowers(new ArrayList<>());
            user.setFollowing(new ArrayList<>());
            user.setPosts(new ArrayList<>());

            return user;
        }

    }


    public int getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
