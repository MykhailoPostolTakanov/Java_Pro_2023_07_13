package bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons/{id}/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountDTO> findAll(@PathVariable("id") String personId, Pageable pageable) {
        return accountService.findAll(personId, pageable);
    }

    @GetMapping("/{id-account}")
    public AccountDTO getAccount(@PathVariable("id") String personId, @PathVariable("id-account") String id) {
        return accountService.findByUID(personId, id);
    }

    @PostMapping
    public AccountDTO createAccount(@PathVariable("id") String personId, @RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(personId, accountDTO);
    }

    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable("account_id") String id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/{account_id}")
    public AccountDTO updateAccount(@PathVariable("account_id") String id, AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }
}
