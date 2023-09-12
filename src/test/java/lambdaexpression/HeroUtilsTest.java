package lambdaexpression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HeroUtilsTest {
    private final List<Hero> heroes = new LinkedList<>();

    @BeforeEach
    public void initList() {
        heroes.add(new Hero("A-Bomb", "Male", "yellow", "Human", "No Hair", 203, "Marvel Comics", "-", "good", 441));
        heroes.add(new Hero("Abe Sapien", "Male", "blue", "Icthyo Sapien", "No Hair", 191, "Dark Horse Comics", "blue", "good", 65));
        heroes.add(new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90));
        heroes.add(new Hero("Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99));
        heroes.add(new Hero("Angel Salvadore", "Female", "brown", "-", "Black", 163, "Marvel Comics", "-", "good", 54));
        heroes.add(new Hero("Amazo", "Male", "red", "Android", "-", 257, "DC Comics", "-", "bad", 173));
    }

    @Test
    void getAverageHeightOfTheHeroesIsMoreThanZero() {
        double result = HeroUtils.getAverageHeightOfTheHeroesIsMoreThanZero(heroes);
        double expected = 199.8;
        assertEquals(expected, result);
    }

    @Test
    void getNameOfTheHighestHero() {
        String result = HeroUtils.getNameOfTheHighestHero(heroes);
        String expected = "Amazo";
        assertEquals(expected, result);
    }

    @Test
    void getNameOfTheMostHeaviestHero() {
        String result = HeroUtils.getNameOfTheMostHeaviestHero(heroes);
        String expected = "A-Bomb";
        assertEquals(expected, result);
    }

    @Test
    void getNumberOfHeroesInEachGenderGroup() {
        Map<String, Long> result = HeroUtils.getNumberOfHeroesInEachGenderGroup(heroes);
        Map<String, Long> expected = new HashMap<>();
        expected.put("Male", 5L);
        expected.put("Female", 1L);
        assertEquals(expected, result);
    }

    @Test
    void getNumberOfPeopleInEachAlignmentGroup() {
        Map<String, Long> result = HeroUtils.getNumberOfPeopleInEachAlignmentGroup(heroes);
        Map<String, Long> expected = new HashMap<>();
        expected.put("good", 4L);
        expected.put("bad", 2L);
        assertEquals(expected, result);
    }

    @Test
    void getNamesOfTheMostPopularPublishers() {
        List<String> result = HeroUtils.getNamesOfTheMostPopularPublishers(heroes, 2);
        List<String> expected = new LinkedList<>();
        expected.add("Marvel Comics");
        expected.add("DC Comics");
        assertEquals(expected, result);
    }

    @Test
    void getNamesOfTheMostCommonHairColors() {
        List<String> result = HeroUtils.getNamesOfTheMostCommonHairColors(heroes, 2);
        List<String>  expected =new LinkedList<>();
        expected.add("No Hair");
        expected.add("-");
        assertEquals(expected, result);
    }

    @Test
    void getMostCommonEyeColor() {
        String result = HeroUtils.getMostCommonEyeColor(heroes);
        String expected = "blue";
        assertEquals(expected, result);
    }
}