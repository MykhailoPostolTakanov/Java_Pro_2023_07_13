package bank.person;

import bank.currencyconverter.DummyCurrencyConverter;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class PersonOperationsServiceTest {

    @Test
    void convert() throws ExecutionException, InterruptedException {
        var personOperationsService = new PersonOperationsService(new DummyCurrencyConverter());
        double amountConverted = personOperationsService.convert(Currency.getInstance("USD"), Currency.getInstance("EUR"), 100);
        assertEquals(200, amountConverted);
    }
}