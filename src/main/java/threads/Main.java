package threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        double a = Math.random() * 3;
        System.out.println(a);
        double[] array = {a, a, a, a, a, a, a, a, a, a};
        ArrayInitializer.init(array);
        for (double d : ArrayInitializer.getArr())
            System.out.println(d);
    }
}
