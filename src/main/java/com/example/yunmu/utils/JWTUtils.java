package com.example.yunmu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {
    private final String secret = "123456";

    public String getToken(String name) {
        String token = null;
        try {
            token = JWT.create().withAudience(name).sign(Algorithm.HMAC256(secret));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public String verify(String token) {
        String username = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            verifier.verify(token);
            username = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }
}
