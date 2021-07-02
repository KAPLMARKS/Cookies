package com.simbirsoft.models;

import com.simbirsoft.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String hashPassword;

    private String email;

    private String cabinet;

    public enum Role{
        ADMIN, EMPLOYEE
    }

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // token for rest

    @Transient
    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> productList;


    public static UsersT castToModel(UserDto userDto){
        return UsersT.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .role(userDto.getRole())
                .build();
    }


    public String getRole() {
        return role.toString();
    }
}
