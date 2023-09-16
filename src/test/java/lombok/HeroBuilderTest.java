package lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {

    @Test
    void builder() {
        HeroBuilder heroBuilderExpected = new HeroBuilder(
                "A-Bomb",
                "Male",
                "yellow",
                "Human",
                "No Hair",
                203,
                "Marvel Comics",
                "-",
                "good",
                441);
        HeroBuilder.HeroBuilderBuilder builder = HeroBuilder.builder();
        builder.name("A-Bomb");
        builder.gender("Male");
        builder.eyeColor("yellow");
        builder.race("Human");
        builder.hairColor("No Hair");
        builder.height(203);
        builder.publisher("Marvel Comics");
        builder.skinColor("-");
        builder.alignment("good");
        builder.weight(441);
        HeroBuilder heroBuilder = builder.build();
        System.out.println(heroBuilder.name);
        assertEquals(heroBuilderExpected, heroBuilder);
    }
}