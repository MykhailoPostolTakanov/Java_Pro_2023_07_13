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
}
