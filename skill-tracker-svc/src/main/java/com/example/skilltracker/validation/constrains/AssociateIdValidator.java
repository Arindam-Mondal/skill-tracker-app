package com.example.skilltracker.validation.constrains;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssociateIdValidator implements ConstraintValidator<AssociateId,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value.startsWith("CTS")) return true;
        return false;
    }
}
