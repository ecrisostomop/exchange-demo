package efcparedes.jwtdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationResponse {
    String date;
    OperationRequest query;
    Double result;
}
