package com.stackroute.authenticationservice.filter;

import com.stackroute.authenticationservice.model.UserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;


@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator{
    @Value("${jwt.secret}")
    private String secret;

    @Value("${app.jwttoken.message}")
    private String message;

    @Override
    public Map<String, String> generateToken(UserDetails userDetails) {
        String jwtToken = "";
        long expiry=10_000_00;
        Map<String, Object> userdata = new HashMap<>();

        userdata.put("username", userDetails.getUsername());
        userdata.put("password", userDetails.getPassword());
        userdata.put("role", userDetails.getRole());

        jwtToken = Jwts.builder().setClaims(userdata)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiry))
                .signWith(SignatureAlgorithm.HS256, "secret").compact();

        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", "Login Successful");
        return jwtTokenMap;



    }
}
