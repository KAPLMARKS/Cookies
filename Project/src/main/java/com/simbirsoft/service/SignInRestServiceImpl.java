package com.simbirsoft.service;

import com.simbirsoft.dto.SignInDto;
import com.simbirsoft.dto.TokenDto;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SignInRestServiceImpl implements SignInRestService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInDto signInDto) {

        Optional<UsersT> usersTOptional = userRepository.findUsersTByName(signInDto.getName());

        if(usersTOptional.isPresent()){
            UsersT usersT = usersTOptional.get();
            if(passwordEncoder.matches(signInDto.getPassword(), usersT.getHashPassword())){
                String token = Jwts.builder()
                     .setSubject(usersT.getId().toString())
                     .claim("name", usersT.getName())
                     .claim("role", usersT.getRole())
                     .signWith(SignatureAlgorithm.HS256, secret)
                     .compact();

                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong name/password");
        } else throw new AccessDeniedException("User nor found");
    }

    @Override
    public TokenDto signInWithHashPassword(SignInDto signInDto) {
        Optional<UsersT> usersTOptional = userRepository.findUsersTByName(signInDto.getName());

        if(usersTOptional.isPresent()){
            UsersT usersT = usersTOptional.get();
            if(usersT.getHashPassword().equals(signInDto.getPassword())){
                String token = Jwts.builder()
                        .setSubject(usersT.getId().toString())
                        .claim("name", usersT.getName())
                        .claim("role", usersT.getRole())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();

                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong name/password");
        } else throw new AccessDeniedException("User nor found");
    }
}