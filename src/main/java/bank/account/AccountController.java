package bank.account;

import bank.person.PersonDTO;
import bank.person.PersonService;
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
    public List<AccountDTO> findAll(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    @GetMapping("/{id-account}")
    public AccountDTO getAccount(@PathVariable("/{id-account}") String id) {
        return accountService.findByUID(id);
    }

    @PostMapping
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @DeleteMapping("/{id-account}")
    public void deleteAccount(@PathVariable("/{id-account}") String id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/{id-account}")
    public AccountDTO updateAccount(@PathVariable("/{id-account}") String id, AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }
}
