package bank.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionRequest(
        @JsonProperty("from")
        String fromCardUID,
        @JsonProperty("to")
        String toCardID,
        int amount
) {
}
