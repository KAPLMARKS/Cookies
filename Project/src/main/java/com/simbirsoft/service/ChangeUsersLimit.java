package com.simbirsoft.service;

import com.simbirsoft.dto.UserDto;
import com.simbirsoft.models.Limits;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;

import java.util.List;

public interface ChangeUsersLimit {

    void changeLimits(List<UsersT> users, List<Product> products, Long days, Long quant);

}