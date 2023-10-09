package JDBC;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        HeroDao heroDao = new HeroDaoImpl(createDataSource());
        Stream<Hero> heroStream = Stream.of(
                new Hero(-1L, "Misha", "Male", "Blue", "Human", "Balck", 1.76, "Ukraine", "White", "good", 74),
                new Hero(-1L, "Superman", "Male", "Blue", "Kryptonian", "Black", 1.91, "DC Comics", "-", "good", 101),
                new Hero(-1L, "A-Bomb", "Male", "yellow", "Human", "No Hair", 2.03, "Marvel Comics", "-", "good", 441));
        List<Hero> heroes = heroStream.toList();
        heroes.forEach(heroDao::create);

        List<Hero> heroesFounded = heroDao.findAll();
        heroesFounded.forEach(System.out::println);

        List<Hero> heroesFoundedByName = heroDao.findByName("Misha");
        heroesFoundedByName.forEach(hero -> {
            Hero heroForUpdating = new Hero(hero.getId(), "Misha Postol-Takanov", "Male", "Blue", "Human", "Black", 1.76, "Ukraine", "White", "good", 74);
            heroDao.update(heroForUpdating);
        });


        List<Hero> heroesFoundedByNameForDeleting = heroDao.findByName("Superman");
        heroesFoundedByNameForDeleting.forEach(hero -> System.out.println(heroDao.delete(hero.getId())));
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
