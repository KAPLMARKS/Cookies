package com.simbirsoft.service;

import com.simbirsoft.dto.SignUpDto;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements  SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void signUp(SignUpDto form) {
        UsersT usersT = UsersT.builder()
                .name(form.getName())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(UsersT.Role.EMPLOYEE)
                .cabinet(form.getCabinet())
                .build();
        userRepository.save(usersT);
    }
}
