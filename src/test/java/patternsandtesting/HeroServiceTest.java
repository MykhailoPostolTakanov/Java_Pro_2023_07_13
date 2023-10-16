package patternsandtesting;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceTest {

    @Test
    void getHeroes() {
        HeroService mock = mock(HeroService.class);
        when(mock.getHeroes()).thenReturn(List.of(new HeroDto("A-Bomb", List.of("Movie", "Movie 2", "Movie 3"))));
        List<HeroDto> heroDtos = mock.getHeroes();
        var expected = List.of(new HeroDto("A-Bomb", List.of("Movie", "Movie 2", "Movie 3")));
        assertEquals(expected, heroDtos);
    }
}