package dao;

import exceptions.RegistrationException;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao {

    private Map<Integer, User> userMap;

    private UserDao(){
        this.userMap = new HashMap<>();
    }

    private static Optional<UserDao> userDao = Optional.empty();

    public static UserDao getInstance(){
        if(userDao.isEmpty()){
            userDao = Optional.of(new UserDao());
        }

        return userDao.get();
    }

    //in reality we would hit the db to check if email is already in use
    public void registerUser(User user) throws RegistrationException {
        for(User userInMap: this.userMap.values()){
            if(user.getEmailAddress().equals(userInMap.getEmailAddress())){
                throw new RegistrationException("user already present");
            }
        }
        this.userMap.put(user.getId(), user);
    }

    public Optional<User> loginUser(String username, String password){
        for(User userInMap: this.userMap.values()){
            if(username.equals(userInMap.getUsername()) && password.equals(userInMap.getPassword())){
                return Optional.ofNullable(this.userMap.get(userInMap.getId()));
            }
        }
        return Optional.empty();
    }

    public Optional<User> getUser(int userId){
        return Optional.ofNullable(this.userMap.get(userId));
    }

}
