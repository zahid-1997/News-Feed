package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import model.User;

import java.util.Date;

public class Validate {

    public static boolean validateToken(String token, User user){
        String secrectKey = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D";

        Claims claims = Jwts.parser()
                .setSigningKey(secrectKey.getBytes())
                .parseClaimsJws(token)
                .getBody();

        String subject = claims.getSubject();
        String issuer = claims.getIssuer();
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();

        return (subject.equals(user.getUsername()) && issuer.equalsIgnoreCase("news_feed")
        && (expiration.after(issuedAt)));
    }
}
