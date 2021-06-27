package com.simbirsoft.service;

import com.simbirsoft.dto.SignInDto;
import com.simbirsoft.dto.TokenDto;

public interface SignInRestService {

    //метод возвращает токен
    TokenDto signIn(SignInDto signInDto);

    //метод возвращает токен, вместо пароля принимает хэш-пароль
    TokenDto signInWithHashPassword(SignInDto signInDto);
}