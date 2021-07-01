package com.simbirsoft.dto;

import com.simbirsoft.validation.ValidCabinet;
import com.simbirsoft.validation.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class SignUpDto {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @ValidPassword(message = "{errors.invalid.password}")
    private String password;

    @ValidCabinet(message = "{errors.invalid.cabinet}")
    private String cabinet;

    private String name;
}