package bank.account;

import bank.person.Person;
import bank.person.PersonDTO;
import bank.person.PersonRepository;
import bank.person.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public AccountService(AccountRepository accountRepository, PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    public List<AccountDTO> findAll(String person_uid, Pageable pageable) {
        var person = getPersonByUid(person_uid);
        return accountRepository.findAllByPersonid(person.getId(), pageable).stream()
                .map(this::mapAccountToAccountDTO).toList();
    }

    public AccountDTO findByUID(String person_uid, String uid) {
        var person = getPersonByUid(person_uid);
        return mapAccountToAccountDTO(findAccountByUidAndPersonid(uid, person.getId()));
    }

    private Account findAccountByUid(String uid) {
        return accountRepository.findByUid(uid).orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    private Account findAccountByUidAndPersonid(String uid, Long person_id) {
        return accountRepository.findByUidAndPersonid(uid, person_id).orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    public AccountDTO createAccount(String person_uid, AccountDTO accountDTO) {
        var person = getPersonByUid(person_uid);
        return mapAccountToAccountDTO(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(accountDTO.iban())
                .balance(accountDTO.balance())
                .personid(person.getId())
                .build()));
    }

    @Transactional
    public void deleteAccount(String uid) {
        accountRepository.deleteById(findAccountByUid(uid).getId());
    }

    @Transactional
    public AccountDTO updateAccount(String uid, AccountDTO accountDTO) {
        var account = findAccountByUid(uid);
        account.setIban(accountDTO.iban());
        account.setBalance(accountDTO.balance());
        return mapAccountToAccountDTO(accountRepository.save(account));
    }

    private AccountDTO mapAccountToAccountDTO(Account account) {
        var person = personRepository.findById(account.getPersonid()).orElseThrow(() -> new RuntimeException("Person Not Found"));
        return new AccountDTO(account.getUid(), account.getIban(), account.getBalance(), person.getUid());
    }

    private Person getPersonByUid(String person_uid) {
        return personRepository.findByUid(person_uid).orElseThrow(() -> new RuntimeException("Person Not Found"));
    }
}
