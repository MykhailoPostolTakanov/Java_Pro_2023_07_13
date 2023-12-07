package bank.currencyconverter;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;

public class CurrencyApiCurrencyConverter implements CurrencyConverter {
    private WebClient webClient;
    private final CurrencyConverterProperties currencyConverterProperties;

    public CurrencyApiCurrencyConverter(CurrencyConverterProperties currencyConverterProperties) {
        this.currencyConverterProperties = currencyConverterProperties;
    }

    private WebClient getWebClient() {
        if (webClient == null) {
            webClient = WebClient.builder().baseUrl(currencyConverterProperties.getUrl()).build();
        }
        return webClient;
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {
        var response = getWebClient().get()
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
