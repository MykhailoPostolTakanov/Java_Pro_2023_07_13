package bank.card;

import bank.account.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons/{id}/accounts/{id-account}/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public CardDTO createCard(@PathVariable("id-account") String accountId) {
        return cardService.openCard(accountId);
    }
}
