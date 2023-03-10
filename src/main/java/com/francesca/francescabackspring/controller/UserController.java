package com.francesca.francescabackspring.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import com.francesca.francescabackspring.entity.User;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "User", description = "Servicio de usuario")
public class UserController {
    final static String userNameLog = "pisarraguido@gmail.com";
    final static String userPassLog = "manganeta1234";
    @PostMapping("user")
    public User login(@RequestBody User u) {
        // los keys del JSON q mandemos tienen q ser igual q los atributos de User
        String nameUser = u.getMail();
        String pwdUser = u.getPassword();
        if(nameUser.equals(userNameLog) && pwdUser.equals(userPassLog)){
            String token = getJWTToken(u.getMail());
            u.setToken(token);
            return u;
        }
        return null;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
