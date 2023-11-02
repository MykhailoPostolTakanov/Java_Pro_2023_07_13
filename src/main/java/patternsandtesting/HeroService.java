package patternsandtesting;

import JDBC.Hero;
import JDBC.HeroDao;

import java.util.List;

public class HeroService {
    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll().stream()
                .map(hero -> new HeroDto(hero.getName(), heroMovieService.getPlayedIn(hero.getName())))
                .toList();
    }

    public List<Hero> getHeroesByName(String name) {
        return heroDao.findByName(name);
    }

    public List<HeroEntity> getHeroesByID(Long id) {
        return heroDao.findByID(id).stream()
                .map(this::fromHeroToHeroEntity)
                .toList();
    }

    public HeroEntity createHero(Hero hero) {
        heroDao.create(hero);
        return getHeroesByName(hero.getName()).stream()
                .map(this::fromHeroToHeroEntity)
                .findFirst()
                .orElseThrow();
    }

    public HeroEntity updateHero(Hero hero) {
        heroDao.update(hero);
        return getHeroesByID(hero.getId()).stream()
                .findFirst()
                .orElseThrow();
    }

    public void deleteHero(Long id) {
        heroDao.delete(id);
    }

    private HeroEntity fromHeroToHeroEntity(Hero hero) {
        return new HeroEntity(hero.getId(), hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(), hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(), hero.getWeight());
    }
}
