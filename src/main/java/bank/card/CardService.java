package bank.card;

import bank.account.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Slf4j
@Service
public class CardService {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardService(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    public CardDTO openCard(String accountUID) {
        log.info("Start Opening Card with UID={}", accountUID);
        var account = accountRepository.findByUid(accountUID).orElseThrow(() -> new RuntimeException("Account Not Found!"));
        return mapCardToCardDTO(cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .pan(String.valueOf((long) (Math.random() * 10000000000000000L)))
                .account(account)
                .expirationDate(Instant.now().plus(730, ChronoUnit.DAYS))
                .pin(String.valueOf((long) (Math.random() * 10000L)))
                .cvv(String.valueOf((long) (Math.random() * 1000L)))
                .status(CardStatus.ACTIVE.getStatus())
                .person(account.getPerson())
                .build()));
    }

    private CardDTO mapCardToCardDTO(Card card) {
        return new CardDTO(card.getUid(), card.getAccount().getUid(), card.getExpirationDate(), card.getPin(), card.getCvv());
    }
}
