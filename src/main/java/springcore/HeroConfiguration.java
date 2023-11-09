package springcore;

import JDBC.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import patternsandtesting.HeroMovieService;
import patternsandtesting.HeroService;

import javax.sql.DataSource;

@Configuration
@ComponentScan("springcore")
@PropertySource("classpath:application.yml")
public class HeroConfiguration {
    @Value("${db.serverName}")
    private String serverName;
    @Value("${db.dataBaseName}")
    private String dataBaseName;
    @Value("${db.login}")
    private String login;
    @Value("${db.password}")
    private String password;

    @Bean
    public HeroDaoImpl heroDao() {
        return new HeroDaoImpl(createDataSource());
    }

    @Bean
    public HeroService heroService() {
        return new HeroService(heroDao(), heroMovieService());
    }

    @Bean
    public DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{serverName});
        dataSource.setDatabaseName(dataBaseName);
        dataSource.setUser(login);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public HeroMovieService heroMovieService() {
        return new HeroMovieService();
    }
}
