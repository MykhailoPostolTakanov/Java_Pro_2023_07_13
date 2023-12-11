package bank.currencyconverter;

import bank.account.WebIntegrationTest;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CurrencyApiCurrencyConverterTest extends WebIntegrationTest {
    @Test
    void shouldConvert() throws Exception {
        wireMockServer.stubFor(WireMock.get(urlEqualTo("/v3/latest?apikey=&currencies=EUR&base_currency=USD"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"meta\": {\n" +
                                "        \"last_updated_at\": \"2023-12-10T23:59:59Z\"\n" +
                                "    },\n" +
                                "    \"data\": {\n" +
                                "        \"EUR\": {\n" +
                                "            \"code\": \"EUR\",\n" +
                                "            \"value\": 0.9290801343\n" +
                                "        },\n" +
                                "        \"UAH\": {\n" +
                                "            \"code\": \"UAH\",\n" +
                                "            \"value\": 36.6906063298\n" +
                                "        },\n" +
                                "        \"USD\": {\n" +
                                "            \"code\": \"USD\",\n" +
                                "            \"value\": 1\n" +
                                "        }\n" +
                                "    }\n" +
                                "}")));

        var request = get("/currency/convert")
                .queryParam("from", "USD")
                .queryParam("to", "EUR")
                .queryParam("amount", String.valueOf(100));
        var res = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        var resDouble = Double.parseDouble(res);
        assertEquals(92.90801343, resDouble);
    }
}
