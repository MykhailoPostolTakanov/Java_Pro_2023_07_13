package Inheritance;

public class Dog extends Animal {
    private static int count = 0;

    public Dog() {
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака може пробігти не більше 500м.");
            System.out.println("Собака пробігла: 500м.");
        } else {
            System.out.println("Собака пробігла: " + distance + "м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака може пропливсти не більше 10м.");
            System.out.println("Собака пропливла: 200м.");
        } else {
            System.out.println("Собака пропливла: " + distance + "м.");
        }
    }

    public static int getCount() {
        return count;
    }
}
