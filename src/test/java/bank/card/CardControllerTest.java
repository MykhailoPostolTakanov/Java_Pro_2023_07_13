package bank.card;

import bank.account.Account;
import bank.account.WebIntegrationTest;
import bank.person.Person;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CardControllerTest extends WebIntegrationTest {

    @Test
    void createCard() throws Exception {
        var personUID = UUID.randomUUID().toString();
        var person = personRepository.save(Person.builder()
                .uid(personUID)
                .name("Misha Postol-Takanov")
                .build());
        var accountUID = UUID.randomUUID().toString();
        var account = accountRepository.save(Account.builder()
                .uid(accountUID)
                .iban("UA100000555")
                .balance(123456789)
                .person(person)
                .build());

        var request = post("/api/persons/" + person.getUid() + "/accounts/" + accountUID + "/cards")
                .content(accountUID)
                .contentType("application/json");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.account_id", equalTo(accountUID)))
                .andExpect(jsonPath("$.expiration_date", is(notNullValue())))
                .andExpect(jsonPath("$.pin", is(notNullValue())))
                .andExpect(jsonPath("$.cvv", is(notNullValue())));
    }
}