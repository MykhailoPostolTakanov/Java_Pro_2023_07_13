package lombok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroLombokTest {
    private HeroLombok heroLombok;

    @BeforeEach
    public void initHero() {
        heroLombok = new HeroLombok(
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
        assertEquals("A-Bomb", heroLombok.getName());
    }

    @Test
    void getGender() {
        assertEquals("Male", heroLombok.getGender());
    }

    @Test
    void getEyeColor() {
        assertEquals("yellow", heroLombok.getEyeColor());
    }

    @Test
    void getRace() {
        assertEquals("Human", heroLombok.getRace());
    }

    @Test
    void getHairColor() {
        assertEquals("No Hair", heroLombok.getHairColor());
    }

    @Test
    void getHeight() {
        assertEquals(203, heroLombok.getHeight());
    }

    @Test
    void getPublisher() {
        assertEquals("Marvel Comics", heroLombok.getPublisher());
    }

    @Test
    void getSkinColor() {
        assertEquals("-", heroLombok.getSkinColor());
    }

    @Test
    void getAlignment() {
        assertEquals("good", heroLombok.getAlignment());
    }

    @Test
    void getWeight() {
        assertEquals(441, heroLombok.getWeight());
    }

    @Test
    void setName() {
        heroLombok.setName("TestName");
        assertEquals("TestName", heroLombok.getName());
    }

    @Test
    void setGender() {
        heroLombok.setGender("TestGender");
        assertEquals("TestGender", heroLombok.getGender());
    }

    @Test
    void setEyeColor() {
        heroLombok.setEyeColor("TestEyeColor");
        assertEquals("TestEyeColor", heroLombok.getEyeColor());
    }

    @Test
    void setRace() {
        heroLombok.setRace("TestRace");
        assertEquals("TestRace", heroLombok.getRace());
    }

    @Test
    void setHairColor() {
        heroLombok.setHairColor("TestHairColor");
        assertEquals("TestHairColor", heroLombok.getHairColor());
    }

    @Test
    void setHeight() {
        heroLombok.setHeight(176);
        assertEquals(176, heroLombok.getHeight());
    }

    @Test
    void setPublisher() {
        heroLombok.setPublisher("TestPublisher");
        assertEquals("TestPublisher", heroLombok.getPublisher());
    }

    @Test
    void setSkinColor() {
        heroLombok.setSkinColor("TestSkinColor");
        assertEquals("TestSkinColor", heroLombok.getSkinColor());
    }

    @Test
    void setAlignment() {
        heroLombok.setAlignment("TestAlignment");
        assertEquals("TestAlignment", heroLombok.getAlignment());
    }

    @Test
    void setWeight() {
        heroLombok.setWeight(100);
        assertEquals(100, heroLombok.getWeight());
    }

    @Test
    void testEquals() {
        HeroLombok heroLombokExpected = new HeroLombok(
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
        assertEquals(heroLombokExpected, heroLombok);
    }

    @Test
    void canEqual() {
        HeroLombok heroLombokExpected = new HeroLombok(
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
        assertEquals(heroLombokExpected, heroLombok);
    }

    @Test
    void testHashCode() {
        HeroLombok heroLombokExpected = new HeroLombok(
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
        assertEquals(heroLombokExpected.hashCode(), heroLombok.hashCode());
    }

    @Test
    void testToString() {
        HeroLombok heroLombokExpected = new HeroLombok(
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
        assertEquals(heroLombokExpected.toString(), heroLombok.toString());
    }
}