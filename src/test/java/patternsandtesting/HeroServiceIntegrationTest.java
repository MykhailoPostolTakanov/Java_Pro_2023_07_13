package patternsandtesting;

import JDBC.Hero;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceIntegrationTest {
    private final HeroFabric fabric = new HeroFabric();
    private final HeroService target = fabric.createService(List.of(new Hero(1L, "A-Bomb", "Male", "yellow", "Human", "No Hair", 203, "Marvel Comics", "-", "good", 441),
            new Hero(2L, "Abe Sapien", "Male", "blue", "Icthyo Sapien", "No Hair", 191, "Dark Horse Comics", "blue", "good", 65),
            new Hero(3L, "Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
            new Hero(4L, "Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99),
            new Hero(5L, "Angel Salvadore", "Female", "brown", "-", "Black", 163, "Marvel Comics", "-", "good", 54),
            new Hero(6L, "Amazo", "Male", "red", "Android", "-", 257, "DC Comics", "-", "bad", 173)));

    @Test
    void shouldReturnListOfHeroes() {
        var heroDtos = target.getHeroes();
        System.out.println(heroDtos);
        var expected = List.of(new HeroDto("A-Bomb", List.of("Movie", "Movie 2", "Movie 3")),
                new HeroDto("Abe Sapien", List.of("Misha Movie 2")),
                new HeroDto("Abin Sur", null),
                new HeroDto("Alex Mercer", List.of("Misha Movie 2")),
                new HeroDto("Angel Salvadore", null),
                new HeroDto("Amazo", List.of("Misha Movie 5")));
        assertEquals(expected, heroDtos);
    }
}
