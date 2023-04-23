package service;

import dao.UserDao;
import dto.UserDTO;
import exceptions.RegistrationException;
import model.User;

public class RegistrationService {

    UserDao userDao;

    public RegistrationService(UserDao userDao){
        this.userDao = userDao;
    }

    public void registerUser(UserDTO user) throws RegistrationException {
        User.UserBuilder userBuilder = User.getInstance();
        userBuilder.setId(user.getId());
        userBuilder.setName(user.getName());
        userBuilder.setUsername(user.getUsername());
        userBuilder.setPassword(user.getPassword());
        userBuilder.setEmailAddress(user.getEmailAddress());
        User newUser = userBuilder.build();
        newUser.setId(user.getId());
        this.userDao.registerUser(newUser);
    }


}
