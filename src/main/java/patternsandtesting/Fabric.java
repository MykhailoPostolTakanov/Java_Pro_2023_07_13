package patternsandtesting;

import JDBC.Hero;

import javax.sql.DataSource;
import java.util.List;

public interface Fabric {
    HeroService createService(DataSource dataSource);

    HeroService createService(List<Hero> heroes);
}
