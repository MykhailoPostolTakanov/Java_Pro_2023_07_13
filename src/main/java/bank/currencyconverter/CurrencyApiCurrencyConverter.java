package bank.currencyconverter;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;

public class CurrencyApiCurrencyConverter implements CurrencyConverter {
    private final WebClient webClient;
    private final CurrencyConverterProperties currencyConverterProperties;

    public CurrencyApiCurrencyConverter(CurrencyConverterProperties currencyConverterProperties) {
        this.currencyConverterProperties = currencyConverterProperties;
        webClient = WebClient.builder().baseUrl(currencyConverterProperties.getUrl()).build();
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {
        var response = webClient.get()
                .uri(uri -> uri.path("/v3/latest")
                        .queryParam("apikey", currencyConverterProperties.getApiKey())
                        .queryParam("currencies", to.getCurrencyCode())
                        .queryParam("base_currency", from.getCurrencyCode())
                        .build())
                .retrieve()
                .bodyToMono(CurrencyResponse.class)
                .block()
                .getData();
        return amount * response.get(to.getCurrencyCode()).getValue();
    }
}
