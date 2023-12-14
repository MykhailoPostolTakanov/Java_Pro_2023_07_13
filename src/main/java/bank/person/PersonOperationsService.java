package bank.person;

import bank.currencyconverter.CurrencyConverter;
import lombok.extern.slf4j.Slf4j;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class PersonOperationsService {
    private final CurrencyConverter currencyConverter;

    public PersonOperationsService(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public double convert(Currency from, Currency to, double amount) throws ExecutionException, InterruptedException {
        log.debug("PersonOperationsService convert from={},to={},amount={}", from.getCurrencyCode(), to.getCurrencyCode(), amount);
        log.info("PersonOperationsService convert from={},to={},amount={}", from.getCurrencyCode(), to.getCurrencyCode(), amount);
        log.error("PersonOperationsService convert from={},to={},amount={}", from.getCurrencyCode(), to.getCurrencyCode(), amount);
        log.warn("PersonOperationsService convert from={},to={},amount={}", from.getCurrencyCode(), to.getCurrencyCode(), amount);
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> currencyConverter.convert(from, to, amount));
        return completableFuture.get();
    }
}
