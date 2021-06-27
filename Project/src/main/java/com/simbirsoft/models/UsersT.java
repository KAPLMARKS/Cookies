package com.simbirsoft.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


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
    private String password;

    public enum Role{
        ADMIN, EMPLOYEE
    }

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // token for rest

    @Transient
    private String token;
}
