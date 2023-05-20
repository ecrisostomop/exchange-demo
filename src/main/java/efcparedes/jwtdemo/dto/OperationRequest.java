package efcparedes.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import efcparedes.jwtdemo.validations.CurrencyValid;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationRequest {
    @NotNull
    @NotEmpty
    @CurrencyValid
    String to;

    @NotNull
    @NotEmpty
    @CurrencyValid
    String from;

    @Min(1)
    Double amount;
}
