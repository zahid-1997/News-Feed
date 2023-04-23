package org.example;

import Strategy.UpvoteDownvoteStragtegy;
import controller.NewsFeedController;
import controller.PostController;
import dao.PostDao;
import dao.UserDao;
import dto.UserDTO;
import exceptions.LoginException;
import exceptions.RegistrationException;
import model.LoginToken;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        setUp();
        addPost();
    }

    private static void addPost() throws Exception {

        UserDao userDao = UserDao.getInstance();
        PostDao postDao = PostDao.getInstance();
        LoginToken loginToken = LoginToken.getInstance();
        LoginService loginService = new LoginService(userDao, loginToken);
        CommentService commentService = new CommentService(postDao, userDao, loginService);
        PostService postService = new PostService(userDao, postDao, loginService, commentService, new UpvoteDownvoteStragtegy(postDao));
        PostController postController = new PostController(postService);
        postController.addPost(1, "Hello");

    }

    private static void setUp() throws RegistrationException, LoginException {

        UserDao userDao = UserDao.getInstance();
        LoginToken loginToken = LoginToken.getInstance();

        RegistrationService registrationService = new RegistrationService(userDao);
        LoginService loginService = new LoginService(userDao, loginToken);
        UserService userService = new UserService(userDao, loginService);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("abc");
        userDTO.setEmailAddress("abc@gmail.com");
        userDTO.setUsername("abc");
        userDTO.setPassword("abc@123");

        NewsFeedController newsFeedController = new NewsFeedController(registrationService, loginService, userService);
        newsFeedController.registerUser(userDTO);
        newsFeedController.loginUser("abc", "abc@123");
        System.out.println("Login Successfull!!!!");
    }
}