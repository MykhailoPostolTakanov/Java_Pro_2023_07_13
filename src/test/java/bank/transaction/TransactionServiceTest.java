package bank.transaction;

import bank.account.Account;
import bank.account.AccountRepository;
import bank.card.Card;
import bank.card.CardRepository;
import bank.card.CardStatus;
import bank.person.Person;
import org.eclipse.jetty.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private CardRepository cardRepository;

    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService(accountRepository, cardRepository);
    }

    @Test
    void transferOfFunds() {
        when(cardRepository.findByUid("cardUid1")).thenReturn(Optional.ofNullable(Card.builder()
                .uid("cardUid1")
                .pan(String.format("%03d", (long) (Math.random() * 10000000000000000L)))
                .account(Account.builder()
                        .uid("accountId1")
                        .iban("UA123456789")
                        .balance(15000)
                        .person(Person.builder()
                                .name("Misha")
                                .uid("Bla-bla-bla-Bla-bla-bla")
                                .accounts(List.of())
                                .build())
                        .build())
                .expirationDate(Instant.now().plus(730, ChronoUnit.DAYS))
                .pin(String.format("%03d", (long) (Math.random() * 10000L)))
                .cvv(String.format("%03d", (long) (Math.random() * 1000L)))
                .status(CardStatus.ACTIVE.getStatus())
                .person(Person.builder()
                        .name("Misha")
                        .uid("Bla-bla-bla-Bla-bla-bla")
                        .accounts(List.of())
                        .build())
                .build()));
        when(cardRepository.findByUid("cardUid2")).thenReturn(Optional.ofNullable(Card.builder()
                .uid("cardUid2")
                .pan(String.format("%03d", (long) (Math.random() * 10000000000000000L)))
                .account(Account.builder()
                        .uid("accountId2")
                        .iban("UA123456789")
                        .balance(15000)
                        .person(Person.builder()
                                .name("Misha")
                                .uid("Bla-bla-bla-Bla-bla-bla")
                                .accounts(List.of())
                                .build())
                        .build())
                .expirationDate(Instant.now().plus(730, ChronoUnit.DAYS))
                .pin(String.format("%03d", (long) (Math.random() * 10000L)))
                .cvv(String.format("%03d", (long) (Math.random() * 1000L)))
                .status(CardStatus.ACTIVE.getStatus())
                .person(Person.builder()
                        .name("Misha")
                        .uid("Bla-bla-bla-Bla-bla-bla")
                        .accounts(List.of())
                        .build())
                .build()));

        var result = transactionService.transferOfFunds(new TransactionRequest("cardUid1", "cardUid2", 1000));
        assertThat(result.getStatusCode().value(), equalTo(HttpStatus.OK_200));
    }
}