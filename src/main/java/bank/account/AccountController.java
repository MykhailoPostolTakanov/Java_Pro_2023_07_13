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
    public List<AccountDTO> findAll(@PathVariable("id") String person_id, Pageable pageable) {
        return accountService.findAll(person_id, pageable);
    }

    @GetMapping("/{id-account}")
    public AccountDTO getAccount(@PathVariable("id") String person_id, @PathVariable("id-account") String id) {
        return accountService.findByUID(person_id, id);
    }

    @PostMapping
    public AccountDTO createAccount(@PathVariable("id") String person_id, @RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(person_id, accountDTO);
    }

    @DeleteMapping("/{id-account}")
    public void deleteAccount(@PathVariable("id-account") String id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/{id-account}")
    public AccountDTO updateAccount(@PathVariable("id-account") String id, AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }
}
