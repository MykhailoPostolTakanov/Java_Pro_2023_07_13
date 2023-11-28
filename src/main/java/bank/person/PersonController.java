package bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll(Pageable pageable) {
        return personService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") String id) {
        return personService.findByUID(id);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable("id") String id, PersonDTO personDTO) {
        return personService.updatePerson(id, personDTO);
    }
}
