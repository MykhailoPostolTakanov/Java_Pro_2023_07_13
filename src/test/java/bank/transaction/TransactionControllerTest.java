package bank.transaction;

import bank.account.Account;
import bank.account.WebIntegrationTest;
import bank.card.Card;
import bank.card.CardStatus;
import bank.person.Person;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TransactionControllerTest extends WebIntegrationTest {

    @Test
    void transferOfFunds() throws Exception {
        var personUID = UUID.randomUUID().toString();
        var person = personRepository.save(Person.builder()
                .uid(personUID)
                .name("Misha")
                .build());

        var accountUID1 = UUID.randomUUID().toString();
        var account1 = accountRepository.save(Account.builder()
                .uid(accountUID1)
                .iban("UA100000555")
                .balance(15000)
                .person(person)
                .build());
        var accountUID2 = UUID.randomUUID().toString();
        var account2 = accountRepository.save(Account.builder()
                .uid(accountUID2)
                .iban("UA100000555")
                .balance(14000)
                .person(person)
                .build());

        var cardUID1 = UUID.randomUUID().toString();
        var card1 = cardRepository.save(Card.builder()
                .uid(cardUID1)
                .pan("1111222233334444")
                .account(account1)
                .expirationDate(Instant.now().plus(730, ChronoUnit.DAYS))
                .pin(String.format("%03d", (long) (Math.random() * 10000L)))
                .cvv(String.format("%03d", (long) (Math.random() * 1000L)))
                .status(CardStatus.ACTIVE.getStatus())
                .person(person)
                .build());
        var cardUID2 = UUID.randomUUID().toString();
        var card2 = cardRepository.save(Card.builder()
                .uid(cardUID2)
                .pan("5555666677778888")
                .account(account2)
                .expirationDate(Instant.now().plus(730, ChronoUnit.DAYS))
                .pin(String.format("%03d", (long) (Math.random() * 10000L)))
                .cvv(String.format("%03d", (long) (Math.random() * 1000L)))
                .status(CardStatus.ACTIVE.getStatus())
                .person(person)
                .build());

        var requestBody = new TransactionRequest(cardUID1, cardUID2, 1000);
        var request = post("/api/transactions")
                .content(objectMapper.writeValueAsBytes(requestBody))
                .contentType("application/json");
        mockMvc.perform(request)
                .andExpect(status().isOk());

        int balance1 = accountRepository.findByUid(accountUID1).orElseThrow().getBalance();
        int balance2 = accountRepository.findByUid(accountUID2).orElseThrow().getBalance();
        assertEquals(14000, balance1);
        assertEquals(15000, balance2);
    }
}