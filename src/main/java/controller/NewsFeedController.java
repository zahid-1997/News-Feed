package controller;


import dto.UserDTO;
import exceptions.LoginException;
import exceptions.RegistrationException;
import model.User;
import service.LoginService;
import service.RegistrationService;
import service.UserService;
import java.util.Optional;

public class NewsFeedController {

    private RegistrationService registrationService;
    private LoginService loginService;

    private UserService userService;

    public NewsFeedController(RegistrationService registrationService, LoginService loginService, UserService userService){
        this.loginService = loginService;
        this.registrationService = registrationService;
        this.userService = userService;
    }

    public void registerUser(UserDTO user) throws RegistrationException {
        Optional<User> optionalUser = userService.getUser(user.getId());
        if(optionalUser.isPresent()){
            throw new RegistrationException("user already registered!!!");
        }

        registrationService.registerUser(user);
    }

    public boolean loginUser(String username, String password) throws LoginException {
        return this.loginService.loginUser(username, password);
    }

}
