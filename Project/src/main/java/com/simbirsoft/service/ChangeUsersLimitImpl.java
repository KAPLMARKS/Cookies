package com.simbirsoft.service;

import com.simbirsoft.models.Limits;
import com.simbirsoft.models.Product;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChangeUsersLimitImpl implements ChangeUsersLimit {
    @Autowired
    LimitRepository limitRepository;

    @Override
    public void changeLimits(List<UsersT> users, List<Product> products, Long days, Long quant) {
        for (UsersT u : users) {
            List<Limits> limits = limitRepository.findByUserId(u.getId());
            List<Long> prod_ids = limits.stream().map(Limits::getProductId).collect(Collectors.toList());
            for (Product p : products) {
                if (prod_ids.contains(p.getProductID()))
                    limitRepository.changeLimit(u.getId(),
                            days,
                            p.getProductID(),
                            quant);
                else
                    limitRepository.addNewLimit(u.getId(),
                            days,
                            0l,
                            p.getProductID(),
                            quant,
                            0l);

            }

        }
    }
}
