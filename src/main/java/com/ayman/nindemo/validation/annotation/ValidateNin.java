package com.ayman.nindemo.validation.annotation;

import com.ayman.nindemo.validation.validator.NinValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NinValidator.class)
public @interface ValidateNin {
    public String message() default "invalid nin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
