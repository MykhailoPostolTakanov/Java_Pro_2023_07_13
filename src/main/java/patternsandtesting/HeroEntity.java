package patternsandtesting;

public class HeroEntity {
    Long id;
    String name;// ім'я
    String gender;// стать
    String eyeColor;// колір очей
    String race;// раса
    String hairColor;// колір волосся
    double height;// зріст
    String publisher; // видавець
    String skinColor;// колір шкіри
    String alignment;// добро / зло
    int weight;// вага

    public HeroEntity(Long id, String name, String gender, String eyeColor, String race, String hairColor, double height, String publisher, String skinColor, String alignment, int weight) {
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
    }
}
