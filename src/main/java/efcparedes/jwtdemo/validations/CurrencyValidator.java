package efcparedes.jwtdemo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyValidator implements
        ConstraintValidator<CurrencyValid, String> {

    @Override
    public void initialize(CurrencyValid constraintAnnotation) {
        // Do nothing for the moment
    }

    /**
     * Validates if the given currency code is PEN or USD
     *
     * @param currency String
     * @param context ConstraintValidatorContext
     */
    @Override
    public boolean isValid(String currency, ConstraintValidatorContext context) {
        return currency.equals("PEN") || currency.equals("USD");
    }

}