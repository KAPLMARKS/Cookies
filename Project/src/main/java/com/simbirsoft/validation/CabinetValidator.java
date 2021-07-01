package com.simbirsoft.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CabinetValidator implements ConstraintValidator<ValidCabinet, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.length() < 4 && value.matches("\\d+");
    }
}
