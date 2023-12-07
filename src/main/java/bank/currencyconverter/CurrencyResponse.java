package bank.currencyconverter;

import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyResponse {
    private Map<String, CurrencyCustom> data;
}
