package com.ayman.nindemo.validation.annotation;

import com.ayman.nindemo.validation.validator.NinIdUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NinIdUniqueValidator.class)
public @interface NinIdUnique {
    public String message() default "Id not unique nin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
