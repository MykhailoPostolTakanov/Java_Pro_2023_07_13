package bank.transaction;

import bank.account.AccountRepository;
import bank.card.CardRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    public TransactionService(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    @Transactional
    public ResponseEntity transferOfFunds(TransactionRequest request) {
        log.info("Transfer Of Funds Starts: " + request);
        var fromAccount = cardRepository.findByUid(request.fromCardUID()).orElseThrow(() -> new RuntimeException("Card Not Found!")).getAccount();
        var toAccount = cardRepository.findByUid(request.toCardID()).orElseThrow(() -> new RuntimeException("Card Not Found!")).getAccount();
        fromAccount.setBalance(fromAccount.getBalance() - request.amount());
        toAccount.setBalance(toAccount.getBalance() + request.amount());
        return ResponseEntity.ok().build();
    }
}
