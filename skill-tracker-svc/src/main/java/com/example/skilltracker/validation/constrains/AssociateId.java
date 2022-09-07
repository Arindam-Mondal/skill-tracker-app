package com.example.skilltracker.validation.constrains;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AssociateIdValidator.class)
@Documented
public @interface AssociateId {
    String message() default "{AssociateId.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
