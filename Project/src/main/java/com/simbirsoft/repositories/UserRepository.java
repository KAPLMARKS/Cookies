package com.simbirsoft.repositories;

import com.simbirsoft.models.UsersT;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersT, Long> {

    Optional<UsersT> findUsersTByName(String username);

}