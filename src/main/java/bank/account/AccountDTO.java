package bank.account;

import bank.person.PersonDTO;

public record AccountDTO(
        String id,
        String iban,
        int balance,
        PersonDTO person
) {
}
