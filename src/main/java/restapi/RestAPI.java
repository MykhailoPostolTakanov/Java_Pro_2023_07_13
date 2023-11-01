package restapi;

import JDBC.Hero;
import JDBC.HeroDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestAPI {
    private final HeroDao heroDao;

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return heroDao.findAll();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHeroesByID(@PathVariable Long id) {
        return heroDao.findAll().stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PostMapping("/heroes")
    public Hero createHero(@RequestBody Hero hero) {
        heroDao.create(hero);
        return heroDao.findByName(hero.getName()).get(0);
    }

    @PutMapping("/heroes/{id}")
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        heroDao.update(hero);
        return this.getHeroesByID(id);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHeroes(@PathVariable Long id) {
        heroDao.delete(id);
    }
}