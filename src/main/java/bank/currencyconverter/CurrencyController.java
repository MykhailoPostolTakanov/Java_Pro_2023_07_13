package bank.currencyconverter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyConverter currencyConverter;

    @GetMapping("/convert")
    @ResponseBody
    public double convert(@RequestParam Currency from, @RequestParam Currency to, @RequestParam double amount) {
        return currencyConverter.convert(from, to, amount);
    }
}
