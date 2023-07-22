package IntroductionOOPSecondClass;

import IntroductionOOP.Employee;

public class Main {
    public static void main(String[] args) {
        var employee = new Employee("Постол-Таканов Михайло Геннадійович", "Програміст", "example@gmail.com", "+380501111111", 30);
        System.out.println(employee.getName());
        System.out.println(employee.getPosition());
        System.out.println(employee.getEmail());
        System.out.println(employee.getPhoneNumber());
        System.out.println(employee.getAge());
    }
}
