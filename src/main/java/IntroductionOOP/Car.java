package IntroductionOOP;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Car start");
    }

    private void startElectricity() {
        System.out.println("Car startElectricity");
    }

    private void startCommand() {
        System.out.println("Car startCommand");
    }

    private void startFuelSystem() {
        System.out.println("Car startFuelSystem");
    }
}
