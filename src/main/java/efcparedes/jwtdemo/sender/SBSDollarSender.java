package efcparedes.jwtdemo.sender;

import efcparedes.jwtdemo.dto.SBSDollarValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SBSDollarSender {
    /**
     * Check dollar rate for purchasing and selling in the SBS website
     *
     */
    public Mono<SBSDollarValue> getDollarFromSBS() throws IOException {

        URL url = new URL(
                "https://www.sbs.gob.pe/app/pp/sistip_portal/paginas/publicacion/tipocambiopromedio.aspx");
        URLConnection urlConnection = (URLConnection)url.openConnection();

        InputStreamReader inStream = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);

        String line;
        SBSDollarValue sbsDollarValue = new SBSDollarValue();

        while ((line = buff.readLine()) != null) {
            if (line.contains("<td class=\"APLI_fila2\"")){
                Pattern pattern = Pattern.compile("([0-9]\\.[0-9]{3})");
                Matcher matcher = pattern.matcher(line.trim());

                matcher.find(); sbsDollarValue.setCompra(Double.parseDouble(matcher.group(1)));
                matcher.find(); sbsDollarValue.setVenta(Double.parseDouble(matcher.group(1)));
                break;
            }
        }

        return Mono.just(sbsDollarValue);
    }
}
