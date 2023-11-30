package bank.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountDTO(
        String id,
        String iban,
        int balance,
        @JsonProperty("person_id")
        String personId
) {
}
