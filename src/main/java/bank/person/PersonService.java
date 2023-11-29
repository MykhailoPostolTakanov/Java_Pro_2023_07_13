package bank.person;

import bank.account.Account;
import bank.account.AccountDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findAll(Pageable pageable) {
        return personRepository.findAll(pageable).stream()
                .map(this::mapPersonToPersonDTO).toList();
    }

    public PersonDTO findByUID(String uid) {
        return mapPersonToPersonDTO(findPersonByUid(uid));
    }

    private Person findPersonByUid(String uid) {
        return personRepository.findByUid(uid).orElseThrow(() -> new RuntimeException("Person not Found"));
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        return mapPersonToPersonDTO(personRepository.save(Person.builder()
                .name(personDTO.name())
                .uid(UUID.randomUUID().toString())
                .build()));
    }

    @Transactional
    public void deletePerson(String uid) {
        personRepository.deleteById(findPersonByUid(uid).getId());
    }

    @Transactional
    public PersonDTO updatePerson(String uid, PersonDTO personDTO) {
        var person = findPersonByUid(uid);
        person.setName(personDTO.name());
        return mapPersonToPersonDTO(personRepository.save(person));
    }

    private PersonDTO mapPersonToPersonDTO(Person person) {
        return new PersonDTO(person.getUid(), person.getName(), person.getAccounts().stream()
                .map(this::mapAccountToAccountDTO)
                .toList());
    }

    private AccountDTO mapAccountToAccountDTO(Account account) {
        return new AccountDTO(account.getUid(), account.getIban(), account.getBalance(), null);
    }
}
