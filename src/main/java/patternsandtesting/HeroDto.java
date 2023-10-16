package patternsandtesting;

import java.util.List;
import java.util.Objects;

public class HeroDto {
    private final String name;
    private final List<String> movies;

    HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDto heroDto = (HeroDto) o;
        return Objects.equals(name, heroDto.name) && Objects.equals(movies, heroDto.movies);
    }

    @Override
    public String toString() {
        return "HeroDto{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movies);
    }

    public static HeroDtoBuilder builder() {
        return new HeroDtoBuilder();
    }

    public static class HeroDtoBuilder {
        private String name;
        private List<String> movies;

        public HeroDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HeroDtoBuilder movies(List<String> movies) {
            this.movies = movies;
            return this;
        }

        public HeroDto build() {
            return new HeroDto(this.name, this.movies);
        }
    }
}
