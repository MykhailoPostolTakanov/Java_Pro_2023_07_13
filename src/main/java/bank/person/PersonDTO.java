package bank.person;

import bank.account.AccountDTO;

import java.util.List;

public record PersonDTO(
        String id,
        String name,
        List<AccountDTO> accounts
) {
}
