package bank.currencyconverter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyConverter currencyConverter;

    @GetMapping("/convert/{from}/{to}/{amount}")
    public double convert(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        return currencyConverter.convert(Currency.getInstance(from), Currency.getInstance(to), amount);
    }
}
