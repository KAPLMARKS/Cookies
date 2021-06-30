package com.simbirsoft.service;

import com.simbirsoft.models.UsersT;

import java.util.Optional;

public interface UsersService {
    Optional<UsersT> findByUsername(String username);
    UsersT save(UsersT user);
}
