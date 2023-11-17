package patternsandtesting;

import JDBC.Hero;
import JDBC.HeroDaoImpl;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabric implements Fabric {
    @Override
    public HeroService createService(DataSource dataSource) {
        return new HeroService(new HeroDaoImpl(dataSource), new HeroMovieService());
    }

    @Override
    public HeroService createService(List<Hero> heroes) {
        return new HeroService(new DummyHeroDao(heroes), new HeroMovieService());
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
