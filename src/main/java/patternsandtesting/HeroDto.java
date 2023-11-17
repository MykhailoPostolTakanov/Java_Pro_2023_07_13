package patternsandtesting;

import java.util.List;
import java.util.Objects;

public class HeroDto {
    private final Long id;
    private final String name;
    private final String gender;
    private final String eyeColor;
    private final String race;
    private final String hairColor;
    private final double height;
    private final String publisher;
    private final String skinColor;
    private final String alignment;
    private final int weight;
    private final List<String> movies;

    HeroDto(Long id, String name, String gender, String eyeColor, String race, String hairColor, double height, String publisher, String skinColor, String alignment, int weight, List<String> movies) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.race = race;
        this.hairColor = hairColor;
        this.height = height;
        this.publisher = publisher;
        this.skinColor = skinColor;
        this.alignment = alignment;
        this.weight = weight;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getRace() {
        return race;
    }

    public String getHairColor() {
        return hairColor;
    }

    public double getHeight() {
        return height;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "HeroDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", race='" + race + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", height=" + height +
                ", publisher='" + publisher + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", alignment='" + alignment + '\'' +
                ", weight=" + weight +
                ", movies=" + movies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDto heroDto = (HeroDto) o;
        return Double.compare(heroDto.height, height) == 0 && weight == heroDto.weight && Objects.equals(id, heroDto.id) && Objects.equals(name, heroDto.name) && Objects.equals(gender, heroDto.gender) && Objects.equals(eyeColor, heroDto.eyeColor) && Objects.equals(race, heroDto.race) && Objects.equals(hairColor, heroDto.hairColor) && Objects.equals(publisher, heroDto.publisher) && Objects.equals(skinColor, heroDto.skinColor) && Objects.equals(alignment, heroDto.alignment) && Objects.equals(movies, heroDto.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, eyeColor, race, hairColor, height, publisher, skinColor, alignment, weight, movies);
    }

    public static HeroDtoBuilder builder() {
        return new HeroDtoBuilder();
    }

    public static class HeroDtoBuilder {
        private Long id;
        private String name;
        private String gender;
        private String eyeColor;
        private String race;
        private String hairColor;
        private double height;
        private String publisher;
        private String skinColor;
        private String alignment;
        private int weight;
        private List<String> movies;

        public HeroDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public HeroDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HeroDtoBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public HeroDtoBuilder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public HeroDtoBuilder race(String race) {
            this.race = race;
            return this;
        }

        public HeroDtoBuilder hairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public HeroDtoBuilder height(double height) {
            this.height = height;
            return this;
        }

        public HeroDtoBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public HeroDtoBuilder skinColor(String skinColor) {
            this.skinColor = skinColor;
            return this;
        }

        public HeroDtoBuilder alignment(String alignment) {
            this.alignment = alignment;
            return this;
        }

        public HeroDtoBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public HeroDtoBuilder movies(List<String> movies) {
            this.movies = movies;
            return this;
        }

        public HeroDto build() {
            return new HeroDto(this.id, this.name, this.gender, this.eyeColor, this.race, this.hairColor, this.height, this.publisher, this.skinColor, this.alignment, this.weight, this.movies);
        }
    }
}
