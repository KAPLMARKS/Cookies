package com.simbirsoft.dto;

import com.simbirsoft.models.UsersT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto {

    private Long id;

    private String name;

    private String password;

    private UsersT.Role role;

    public static UserDto castToDto(UsersT usersT){
        return UserDto.builder()
                .id(usersT.getId())
                .name(usersT.getName())
                .role(usersT.getRole())
                .build();
    }
}
