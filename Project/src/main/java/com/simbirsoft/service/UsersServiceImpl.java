package com.simbirsoft.service;

import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UsersT> findByUsername(String username) {
        return userRepository.findUsersTByName(username);
    }

    @Override
    public UsersT save(UsersT user) {
        return userRepository.save(user);
    }
}
