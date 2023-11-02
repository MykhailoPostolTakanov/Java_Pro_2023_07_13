package restapi;

import JDBC.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import patternsandtesting.HeroDto;
import patternsandtesting.HeroEntity;
import patternsandtesting.HeroService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestAPI {
    private final HeroService heroService;

    @GetMapping("/heroes")
    public List<HeroDto> getAllHeroes() {
        return heroService.getHeroes();
    }

    @GetMapping("/heroes/{id}")
    public HeroEntity getHeroesByID(@PathVariable Long id) {
        return heroService.getHeroesByID(id).stream()
                .findFirst()
                .orElseThrow();
    }

    @PostMapping("/heroes")
    public HeroEntity createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @PutMapping("/heroes/{id}")
    public HeroEntity updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        return heroService.updateHero(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHeroes(@PathVariable Long id) {
        heroService.deleteHero(id);
    }
}