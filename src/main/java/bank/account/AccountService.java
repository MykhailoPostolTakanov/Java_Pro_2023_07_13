package bank.account;

import bank.person.Person;
import bank.person.PersonRepository;
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

    public List<AccountDTO> findAll(String personUid, Pageable pageable) {
        var person = getPersonByUid(personUid);
        return accountRepository.findAllByPersonId(person.getId(), pageable).stream()
                .map(this::mapAccountToAccountDTO).toList();
    }

    public AccountDTO findByUID(String personUid, String uid) {
        var person = getPersonByUid(personUid);
        return mapAccountToAccountDTO(findAccountByUidAndPersonid(uid, person.getId()));
    }

    private Account findAccountByUid(String uid) {
        return accountRepository.findByUid(uid).orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    private Account findAccountByUidAndPersonid(String uid, Long personId) {
        return accountRepository.findByUidAndPersonId(uid, personId).orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    public AccountDTO createAccount(String personUid, AccountDTO accountDTO) {
        var person = getPersonByUid(personUid);
        return mapAccountToAccountDTO(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(accountDTO.iban())
                .balance(accountDTO.balance())
                .person(person)
                .build()));
    }

    @Transactional
    public void deleteAccount(String uid) {
        accountRepository.delete(findAccountByUid(uid));
    }

    @Transactional
    public AccountDTO updateAccount(String uid, AccountDTO accountDTO) {
        var account = findAccountByUid(uid);
        account.setIban(accountDTO.iban());
        account.setBalance(accountDTO.balance());
        return mapAccountToAccountDTO(account);
    }

    private AccountDTO mapAccountToAccountDTO(Account account) {
        return new AccountDTO(account.getUid(), account.getIban(), account.getBalance(), account.getPerson().getUid());
    }

    private Person getPersonByUid(String personUid) {
        return personRepository.findByUid(personUid).orElseThrow(() -> new RuntimeException("Person Not Found"));
    }
}
