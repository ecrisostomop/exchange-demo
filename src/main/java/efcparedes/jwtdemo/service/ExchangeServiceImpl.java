package efcparedes.jwtdemo.service;

import efcparedes.jwtdemo.sender.SBSDollarSender;
import efcparedes.jwtdemo.dto.OperationRequest;
import efcparedes.jwtdemo.dto.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    SBSDollarSender dollarController;

    /**
     * Given the entered currency codes and an amount, exchanges money
     *
     * @param request OperationRequest
     */
    @Override
    public Mono<OperationResponse> exchange(OperationRequest request) throws IOException {
        return dollarController.getDollarFromSBS()
                .flatMap( dollarInformation -> {
                    OperationResponse response = new OperationResponse();
                    response.setQuery(request);
                    response.setDate(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

                    if (request.getTo().equals("PEN") && request.getFrom().equals("USD")) {
                        response.setResult(round(dollarInformation.getVenta()*request.getAmount(),2));
                    } else if (request.getTo().equals("USD") && request.getFrom().equals("PEN")) {
                        response.setResult(round(request.getAmount()/dollarInformation.getCompra(),2));
                    } else {
                        response.setResult(request.getAmount());
                    }
                    return Mono.just(response);
                }
        );
    }

    /**
     * Round the result to two decimal to show it in response
     *
     * @param value Double
     * @param places Integer
     */
    private static Double round(Double value, Integer places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
