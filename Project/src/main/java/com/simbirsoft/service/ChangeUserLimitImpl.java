package com.simbirsoft.service;

import com.simbirsoft.models.Limit;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.LimitRepository;
import com.simbirsoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChangeUserLimitImpl implements ChangeUserLimit {

    @Autowired
    LimitRepository limitRepository;

    @Override
    public void changeLimits(List<UsersT> users, List<Product> products, int days, int quant) {
        for (UsersT u : users){
            List<Limit> limits = limitRepository.getLimits(u.getId());
            List<Long> prod_ids = limits.stream().map(Limit::getProductId).collect(Collectors.toList());
            for(Product p : products){
                if(prod_ids.contains(p.getProductID()))
                    limitRepository.changeLimit();
                else
                    limitRepository.addNewLimit();
            }

        }
    }
}
