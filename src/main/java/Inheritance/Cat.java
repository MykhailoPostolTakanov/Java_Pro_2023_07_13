package Inheritance;

public class Cat extends Animal {
    private static int count = 0;

    public Cat() {
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кіт може пробігти не більше 200м.");
            System.out.println("Кіт пробіг: 200м.");
        } else {
            System.out.println("Кіт пробіг: " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кіт не вміє плавати!");
    }

    public static int getCount() {
        return count;
    }
}
