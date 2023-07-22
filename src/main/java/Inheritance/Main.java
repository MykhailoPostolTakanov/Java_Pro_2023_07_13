package Inheritance;

public class Main {
    public static void main(String[] args) {
        var cat = new Cat();
        var dog = new Dog();
        cat.run(150);
        cat.run(210);
        cat.swim(10);
        dog.run(350);
        dog.run(560);
        dog.swim(7);
        dog.swim(12);
        var dog2 = new Dog();
        System.out.println("Кількість котиків: " + Cat.getCount());
        System.out.println("Кількість собачок: " + Dog.getCount());
        System.out.println("Кількість тваринок: " + Animal.getCount());
    }
}
