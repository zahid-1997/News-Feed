package service;

import dao.UserDao;
import exceptions.LoginException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.LoginToken;
import model.User;
import java.util.Date;
import java.util.Optional;

public class LoginService {
    UserDao userDao;
    LoginToken loginToken;

    public LoginService(UserDao userDao, LoginToken loginToken){
        this.userDao = userDao;
        this.loginToken = loginToken;
    }

    public boolean loginUser(String username, String password) throws LoginException {
        Optional<User> optionalUser = userDao.loginUser(username, password);
        if(!optionalUser.isPresent()){
            throw new LoginException("User not present! Please register first");
        }
        User user = optionalUser.get();
        Date now = new Date();
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer("news_Feed")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 3600000))//1 hour
                .signWith(SignatureAlgorithm.HS256, "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D".getBytes())
                .compact();

        this.loginToken.getTokens().put(user.getId(), token);
        return true;

    }

    public String getToken(int userid){
        return this.loginToken.getTokens().get(userid);
    }

}
