package com.simbirsoft.security.details;

import com.simbirsoft.dto.SignInDto;
import com.simbirsoft.models.UsersT;
import com.simbirsoft.repositories.UserRepository;
import com.simbirsoft.service.SignInRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignInRestService restService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersT> usersTOptional = userRepository.findUsersTByName(username);
        if (usersTOptional.isPresent()){
            UsersT usersT = usersTOptional.get();
            usersT.setToken(restService.signInWithHashPassword(
                    new SignInDto(usersT.getName(), usersT.getHashPassword())).getToken());

            return new UserDetailsImpl(usersT);
        }
        throw new UsernameNotFoundException("user not found");
    }
}