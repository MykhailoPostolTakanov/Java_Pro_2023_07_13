package patternsandtesting;

import JDBC.HeroDao;

import java.util.List;

public class HeroService {
    private final HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll().stream()
                .map(hero -> new HeroDto(hero.getName(), HeroMovieService.getPlayedIn(hero.getName())))
                .toList();
    }
}
