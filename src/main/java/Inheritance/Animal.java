package Inheritance;

public class Animal {
    private static int count = 0;

    public Animal() {
        count++;
    }

    public void run(int distance) {
        System.out.println("Тваринка пробігає: " + distance + "м.");
    }

    public void swim(int distance) {
        System.out.println("Тваринка пропливає: " + distance + "м.");
    }

    public static int getCount() {
        return count;
    }
}
