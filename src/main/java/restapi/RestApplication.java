package restapi;

import JDBC.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import patternsandtesting.HeroMovieService;
import patternsandtesting.HeroService;

import javax.sql.DataSource;

@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public HeroService heroService() {
        return new HeroService(new HeroDaoImpl(createDataSource()), new HeroMovieService());
    }

    private static DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{"localhost"});
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("hillel");
        dataSource.setPassword("hillel");
        return dataSource;
    }
}
