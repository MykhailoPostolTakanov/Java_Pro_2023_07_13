package patternsandtesting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroMovieService {
    public static Map<String, List<String>> heroMovies;

    static {
        heroMovies = new HashMap<>();
        heroMovies.put("A-Bomb", List.of("Movie", "Movie 2", "Movie 3"));
        heroMovies.put("Misha Postol-Takanov", List.of("Misha Movie", "Misha Movie 2", "Misha Movie 4"));
        heroMovies.put("Abe Sapien", List.of("Misha Movie 2"));
        heroMovies.put("AAbin Sur", List.of("Misha Movie 3"));
        heroMovies.put("Alex Mercer", List.of("Misha Movie 2"));
        heroMovies.put("Amazo", List.of("Misha Movie 5"));
    }

    public List<String> getPlayedIn(String heroName) {
        return heroMovies.get(heroName);
    }
}
