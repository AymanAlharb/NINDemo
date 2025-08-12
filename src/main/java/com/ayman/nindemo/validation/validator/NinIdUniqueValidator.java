package com.ayman.nindemo.validation.validator;

import com.ayman.nindemo.repository.NinRepository;
import com.ayman.nindemo.validation.annotation.NinIdUnique;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NinIdUniqueValidator implements ConstraintValidator<NinIdUnique, Long> {
    private final NinRepository ninRepository;
    @Override
    public boolean isValid(Long ninId, ConstraintValidatorContext constraintValidatorContext) {
        return !ninRepository.findNinById(ninId).isPresent();
    }
}
