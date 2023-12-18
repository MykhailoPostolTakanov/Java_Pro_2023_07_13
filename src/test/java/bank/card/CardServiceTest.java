package bank.card;

import bank.account.Account;
import bank.account.AccountRepository;
import bank.person.Person;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasLength;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {
    @Mock
    private CardRepository cardRepository;
    @Mock
    private AccountRepository accountRepository;
    private CardService cardService;
    @Captor
    ArgumentCaptor<Card> argumentCaptorCard;

    @BeforeEach
    void setUp() {
        cardService = new CardService(cardRepository, accountRepository);
    }

    @Test
    void openCard() {
        when(accountRepository.findByUid("accountId")).thenReturn(Optional.ofNullable(Account.builder()
                .uid("accountId")
                .iban("UA123456789")
                .balance(12456)
                .person(Person.builder()
                        .name("Misha")
                        .uid("Bla-bla-bla-Bla-bla-bla")
                        .accounts(List.of())
                        .build())
                .build()));
        when(cardRepository.save(Mockito.any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        var result = cardService.openCard("accountId");
        assertThat(result.id(), CoreMatchers.notNullValue());
        assertEquals("accountId", result.accountId());
        assertThat(result.expirationDate(), CoreMatchers.notNullValue());
        assertThat(result.pin(), CoreMatchers.notNullValue());
        assertThat(result.pin(), hasLength(4));
        assertThat(result.cvv(), CoreMatchers.notNullValue());
        assertThat(result.cvv(), hasLength(3));
        Mockito.verify(accountRepository).findByUid("accountId");
        Mockito.verify(cardRepository).save(argumentCaptorCard.capture());
        var card = argumentCaptorCard.getValue();
        assertThat(card.getPan(), CoreMatchers.notNullValue());
        assertThat(card.getPerson(), CoreMatchers.notNullValue());
    }
}