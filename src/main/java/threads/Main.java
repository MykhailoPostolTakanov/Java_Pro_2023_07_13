package threads;

public class Main {
    public static void main(String[] args) {
        double a = Math.random() * 3;
        System.out.println(a);
        double[] array = {a, a, a, a, a, a, a, a, a, a};
        ArrayInitializer.init(array);
        System.out.println("--------------");
        for (double d : array)
            System.out.println(d);
        System.out.println("--------------");
    }
}
