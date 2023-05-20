package efcparedes.jwtdemo.controller;

import java.io.IOException;

import efcparedes.jwtdemo.dto.OperationRequest;
import efcparedes.jwtdemo.dto.OperationResponse;
import efcparedes.jwtdemo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
@RequestMapping
@RestController
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;
    @GetMapping("exchange")
    public Mono<OperationResponse> currencyExchange(@RequestBody @Valid OperationRequest request)
            throws IOException {
        return exchangeService.exchange(request);
    }
}