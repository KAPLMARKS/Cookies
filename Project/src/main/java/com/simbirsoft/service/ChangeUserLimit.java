package com.simbirsoft.service;

import com.simbirsoft.dto.UserDto;
import com.simbirsoft.models.Limit;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;

import java.util.List;

public interface ChangeUserLimit {

    void changeLimits(List<UsersT> users, List<Product> products, int days, int quant);

}
