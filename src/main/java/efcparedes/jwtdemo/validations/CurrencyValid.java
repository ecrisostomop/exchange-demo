package efcparedes.jwtdemo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CurrencyValidator.class})
public @interface CurrencyValid {

    String message() default "Currency code must be PEN or USD";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
