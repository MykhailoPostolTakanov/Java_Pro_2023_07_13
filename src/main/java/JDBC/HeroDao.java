package JDBC;

import java.util.List;

public interface HeroDao {
    List<Hero> findAll();

    List<Hero> findByName(String name);

    Hero findByID(Long id);

    void create(Hero hero);

    void update(Hero hero);

    boolean delete(Long id);
}
