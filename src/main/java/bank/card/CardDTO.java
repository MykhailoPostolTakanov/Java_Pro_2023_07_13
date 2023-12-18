package bank.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record CardDTO(
        String id,
        @JsonProperty("account_id")
        String accountId,
        @JsonProperty("expiration_date")
        Instant expirationDate,
        String pin,
        String cvv
) {
}
