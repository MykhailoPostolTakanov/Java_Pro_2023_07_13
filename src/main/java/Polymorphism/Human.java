package Polymorphism;

public class Human implements Member {
    private int maxRun;
    private int maxJump;
    private String title = "Людина";

    public Human(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void run() {
        System.out.println("Людина біжить");
    }

    @Override
    public void jump() {
        System.out.println("Людина стрибає");
    }
}
