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
                .map(this::fromHeroToHeroDTO)
                .toList();
    }

    public List<Hero> getHeroesByName(String name) {
        return heroDao.findByName(name);
    }

    public HeroDto getHeroesByID(Long id) {
        return fromHeroToHeroDTO(heroDao.findByID(id));
    }

    public HeroDto createHero(Hero hero) {
        heroDao.create(hero);
        return getHeroesByName(hero.getName()).stream()
                .map(this::fromHeroToHeroDTO)
                .findFirst()
                .orElseThrow();
    }

    public HeroDto updateHero(Hero hero) {
        heroDao.update(hero);
        return getHeroesByID(hero.getId());
    }

    public void deleteHero(Long id) {
        heroDao.delete(id);
    }

    private HeroEntity fromHeroToHeroEntity(Hero hero) {
        return new HeroEntity(hero.getId(), hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(), hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(), hero.getWeight());
    }

    private HeroDto fromHeroToHeroDTO(Hero hero) {
        return new HeroDto(hero.getId(), hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(), hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(), hero.getWeight(), heroMovieService.getPlayedIn(hero.getName()));
    }
}
