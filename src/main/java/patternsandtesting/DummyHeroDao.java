package patternsandtesting;

import JDBC.Hero;
import JDBC.HeroDao;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DummyHeroDao implements HeroDao {
    private final List<Hero> db;

    @Override
    public List<Hero> findAll() {
        return List.copyOf(db);
    }

    @Override
    public List<Hero> findByName(String name) {
        return db.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public void create(Hero hero) {
        db.add(hero);
    }

    @Override
    public void update(Hero hero) {
        var index = -1;
        for (var i = 0; i < db.size(); i++)
            if (db.get(i).getId().equals(hero.getId())) {
                index = i;
                break;
            }
        if (index != -1)
            db.set(index, hero);
    }

    @Override
    public boolean delete(Long id) {
        return db.remove(db.stream().filter(hero -> hero.getId().equals(id)).toList().get(0));
    }
}
