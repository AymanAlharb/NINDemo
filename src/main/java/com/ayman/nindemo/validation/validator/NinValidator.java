package com.ayman.nindemo.validation.validator;

import com.ayman.nindemo.repository.NinRepository;
import com.ayman.nindemo.validation.annotation.ValidateNin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
@Component
public class NinValidator implements ConstraintValidator<ValidateNin, String> {
    private final NinRepository ninRepository;
    @Override
    public boolean isValid(String nin, ConstraintValidatorContext constraintValidatorContext) {
        return validateNin(nin);
    }

    public boolean validateNin(String nin){
        return (nin.length() == 10
                && ((nin.charAt(0) == '1') || (nin.charAt(0) == '2'))
                && (!ninRepository.findNinByNin(nin).isPresent())
        );
    }
}
