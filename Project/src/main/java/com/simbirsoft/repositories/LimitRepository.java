package com.simbirsoft.repositories;

import com.simbirsoft.models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LimitRepository extends JpaRepository<Limit, Long> {

    List<Limit> getLimits(Long userId);

    //todo написать запрос
    @Query()
    void addNewLimit();

    //todo написать запрос
    void changeLimit();
}
