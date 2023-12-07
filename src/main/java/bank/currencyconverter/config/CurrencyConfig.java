package bank.currencyconverter.config;

import bank.currencyconverter.CurrencyApiCurrencyConverter;
import bank.currencyconverter.CurrencyConverter;
import bank.currencyconverter.CurrencyConverterProperties;
import bank.currencyconverter.DummyCurrencyConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {
    @Configuration
    @ConditionalOnProperty(name = "currency.provider", havingValue = "latest")
    public static class CurrencyProviderConfiguration {
        @Bean
        public CurrencyConverter currencyConverter(CurrencyConverterProperties currencyConverterProperties) {
            return new CurrencyApiCurrencyConverter(currencyConverterProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency.provider", havingValue = "dummy")
    public static class DummyCurrencyProviderConfiguration {
        @Bean
        public CurrencyConverter currencyConverter() {
            return new DummyCurrencyConverter();
        }
    }
}
