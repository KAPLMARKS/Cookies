package com.simbirsoft.service;

import com.simbirsoft.models.UsersT;

public interface UsersService {
    UsersT findByUsername(String username);
    UsersT save(UsersT user);
}
