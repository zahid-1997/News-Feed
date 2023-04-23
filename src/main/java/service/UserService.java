package service;

import dao.UserDao;
import model.User;
import utils.Validate;
import java.util.Optional;

public class UserService {

    UserDao userDao;
    LoginService loginService;

    public UserService(UserDao userDao, LoginService loginService){
        this.userDao = userDao;
        this.loginService = loginService;
    }

    public boolean followUser(int userId, int followingId){
        Optional<User> optionalUser = getUser(userId);
        Optional<User> optionalUserFollowingUser = getUser(followingId);
        if(optionalUser.isPresent() && optionalUserFollowingUser.isPresent()){
            User user = optionalUser.get();
            boolean isSessionValid = Validate.validateToken(loginService.getToken(userId), user);
            if(isSessionValid){
                user.getFollowing().add(followingId);
                optionalUserFollowingUser.get().getFollowers().get(userId);
            }
            return true;
        }

        return false;
    }

    public Optional<User> getUser(int userid){
        return userDao.getUser(userid);
    }


}
