package bank.person;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
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
        MDC.put("uid", uid);
        return mapPersonToPersonDTO(findPersonByUid(uid));
    }

    private Person findPersonByUid(String uid) {
        log.info("Find Person By UID. uid={}", uid);
        return personRepository.findByUid(uid).orElseThrow(() -> new RuntimeException("Person not Found"));
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        log.info("Create Person With Name={}", personDTO.name());
        return mapPersonToPersonDTO(personRepository.save(Person.builder()
                .name(personDTO.name())
                .uid(UUID.randomUUID().toString())
                .accounts(List.of())
                .build()));
    }

    @Transactional
    public void deletePerson(String uid) {
        log.info("Delete Person With uid={}", uid);
        personRepository.deleteById(findPersonByUid(uid).getId());
    }

    @Transactional
    public PersonDTO updatePerson(String uid, PersonDTO personDTO) {
        log.info("Update Person With Name={}", personDTO.name());
        var person = findPersonByUid(uid);
        person.setName(personDTO.name());
        return mapPersonToPersonDTO(personRepository.save(person));
    }

    private PersonDTO mapPersonToPersonDTO(Person person) {
        log.info("Map Person To PersonDTO Name={}", person.getName());
        return new PersonDTO(person.getUid(), person.getName());
    }
}
