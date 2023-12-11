package bank.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockConfiguration {
    public final static WireMockServer wireMockServer = new WireMockServer(4545);

    @Bean
    public WireMockServer getWireMockServer() {
        return wireMockServer;
    }

    @PostConstruct
    public void StartServer() {
        wireMockServer.start();
    }

    @PreDestroy
    public void StopServer() {
        wireMockServer.stop();
    }
}
