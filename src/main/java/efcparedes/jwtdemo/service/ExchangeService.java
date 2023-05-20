package efcparedes.jwtdemo.service;

import efcparedes.jwtdemo.dto.OperationRequest;
import efcparedes.jwtdemo.dto.OperationResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface ExchangeService {
    public Mono<OperationResponse> exchange(OperationRequest request) throws IOException;
}
