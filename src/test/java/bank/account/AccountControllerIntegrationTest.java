package bank.account;

import bank.person.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerIntegrationTest extends WebIntegrationTest {

    @Test
    void findAll() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Misha")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA100000555")
                .balance(123456789)
                .person(person)
                .build());

        var request = get("/api/persons/" + person.getUid() + "/accounts");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[:1].iban", equalTo(List.of(account.getIban()))))
                .andExpect(jsonPath("$[:1].balance", equalTo(List.of(account.getBalance()))))
                .andExpect(jsonPath("$[:1].person_id", equalTo(List.of(person.getUid()))));
    }

    @Test
    void getAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Misha")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA100000555")
                .balance(123456789)
                .person(person)
                .build());

        var request = get("/api/persons/" + person.getUid() + "/accounts/" + account.getUid());
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban", equalTo(account.getIban())))
                .andExpect(jsonPath("$.balance", equalTo(account.getBalance())))
                .andExpect(jsonPath("$.person_id", equalTo(account.getPerson().getUid())));
    }

    @Test
    void createAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Misha")
                .build());
        var accountDTO = new AccountDTO(UUID.randomUUID().toString(), "UA100000555", 123456789, "");
        var request = post("/api/persons/" + person.getUid() + "/accounts")
                .content(objectMapper.writeValueAsBytes(accountDTO))
                .contentType("application/json");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.iban", equalTo(accountDTO.iban())))
                .andExpect(jsonPath("$.balance", equalTo(accountDTO.balance())))
                .andExpect(jsonPath("$.person_id", equalTo(person.getUid())));
    }

    @Test
    void deleteAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Misha")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA100000555")
                .balance(123456789)
                .person(person)
                .build());

        var request = delete("/api/persons/" + person.getUid() + "/accounts/" + account.getUid());
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    void updateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Misha")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA100000555")
                .balance(123456789)
                .person(person)
                .build());
        var accountDTO = new AccountDTO(account.getUid(), "UA100000555123", 1234567891, account.getPerson().getUid());

        var request = put("/api/persons/" + person.getUid() + "/accounts/" + account.getUid())
                .content(objectMapper.writeValueAsBytes(accountDTO))
                .contentType("application/json");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban", equalTo(accountDTO.iban())))
                .andExpect(jsonPath("$.balance", equalTo(accountDTO.balance())))
                .andExpect(jsonPath("$.person_id", equalTo(accountDTO.personId())));
    }
}