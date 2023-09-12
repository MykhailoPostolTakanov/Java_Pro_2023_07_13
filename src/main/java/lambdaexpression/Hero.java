package lambdaexpression;

import java.util.Objects;

public class Hero {
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

    public Hero(String name, String gender, String eyeColor, String race, String hairColor, double height, String publisher, String skinColor, String alignment, int weight) {
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

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEyeColor() {
        return eyeColor;
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

    public String getAlignment() {
        return alignment;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Double.compare(hero.height, height) == 0 && weight == hero.weight && Objects.equals(name, hero.name) && Objects.equals(gender, hero.gender) && Objects.equals(eyeColor, hero.eyeColor) && Objects.equals(race, hero.race) && Objects.equals(hairColor, hero.hairColor) && Objects.equals(publisher, hero.publisher) && Objects.equals(skinColor, hero.skinColor) && Objects.equals(alignment, hero.alignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, eyeColor, race, hairColor, height, publisher, skinColor, alignment, weight);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", race='" + race + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", height=" + height +
                ", publisher='" + publisher + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", alignment='" + alignment + '\'' +
                ", weight=" + weight +
                '}';
    }
}
