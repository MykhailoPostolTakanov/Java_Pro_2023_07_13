package patternsandtesting;

import static org.mockito.Mockito.*;

import JDBC.Hero;
import JDBC.HeroDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {
    @Mock
    private HeroDao heroDao;
    @Mock
    private HeroMovieService heroMovieService;

    @Test
    void getHeroes() {
        when(heroDao.findAll()).thenReturn(List.of(new Hero(11L, "Misha Postol-Takanov", "Male", "Blue", "Human", "Balck", 1.76, "Ukraine", "White", "good", 74),
                new Hero(13L, "A-Bomb", "Male", "yellow", "Human", "No Hair", 2.03, "Marvel Comics", "-", "good", 441)));
        when(heroMovieService.getPlayedIn("A-Bomb")).thenReturn(List.of("Movie", "Movie 2", "Movie 3"));
        when(heroMovieService.getPlayedIn("Misha Postol-Takanov")).thenReturn(List.of("Misha Movie", "Misha Movie 2", "Misha Movie 4"));

        HeroService heroService = new HeroService(heroDao, heroMovieService);
        List<HeroDto> heroDtos = heroService.getHeroes();
        var expected = List.of(new HeroDto("Misha Postol-Takanov", List.of("Misha Movie", "Misha Movie 2", "Misha Movie 4")),
                new HeroDto("A-Bomb", List.of("Movie", "Movie 2", "Movie 3")));
        assertEquals(expected, heroDtos);
    }
}