package com.whu.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.whu.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Hongchao Yang
 * @date 2020-11-03 9:43
 */
@Service
public class TokenService {

    public String getToken(User user){
        Date start = new Date();
        //一小时有效时间
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        Date end = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(user.getUserId().toString()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPwd()));
        return token;
    }

}
