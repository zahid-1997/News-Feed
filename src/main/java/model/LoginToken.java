package model;

import service.LoginService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoginToken {

    Map<Integer, String> tokens;

    private LoginToken(){
        tokens = new HashMap<>();
    }

    private static Optional<LoginToken> loginToken = Optional.empty();

    public static LoginToken getInstance(){
        if(loginToken.isEmpty()){
            synchronized (LoginService.class){
                if(loginToken.isEmpty()){
                    loginToken = Optional.of(new LoginToken());
                }
            }
        }

        return loginToken.get();
    }

    public Map<Integer, String> getTokens() {
        return tokens;
    }

    public void setTokens(Map<Integer, String> tokens) {
        this.tokens = tokens;
    }
}
