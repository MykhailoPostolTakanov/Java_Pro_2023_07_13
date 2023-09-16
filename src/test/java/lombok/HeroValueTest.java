package lombok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroValueTest {
    private HeroValue heroValue;

    @BeforeEach
    public void initHero() {
        heroValue = new HeroValue(
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
    }

    @Test
    void getName() {
        assertEquals("A-Bomb", heroValue.getName());
    }

    @Test
    void getGender() {
        assertEquals("Male", heroValue.getGender());
    }

    @Test
    void getEyeColor() {
        assertEquals("yellow", heroValue.getEyeColor());
    }

    @Test
    void getRace() {
        assertEquals("Human", heroValue.getRace());
    }

    @Test
    void getHairColor() {
        assertEquals("No Hair", heroValue.getHairColor());
    }

    @Test
    void getHeight() {
        assertEquals(203, heroValue.getHeight());
    }

    @Test
    void getPublisher() {
        assertEquals("Marvel Comics", heroValue.getPublisher());
    }

    @Test
    void getSkinColor() {
        assertEquals("-", heroValue.getSkinColor());
    }

    @Test
    void getAlignment() {
        assertEquals("good", heroValue.getAlignment());
    }

    @Test
    void getWeight() {
        assertEquals(441, heroValue.getWeight());
    }

    @Test
    void testEquals() {
        HeroValue heroValueExpected = new HeroValue(
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
        assertEquals(heroValueExpected, heroValue);
    }

    @Test
    void testHashCode() {
        HeroValue heroValueExpected = new HeroValue(
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
        assertEquals(heroValueExpected.hashCode(), heroValue.hashCode());
    }

    @Test
    void testToString() {
        HeroValue heroValueExpected = new HeroValue(
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
        assertEquals(heroValueExpected.toString(), heroValue.toString());
    }
}