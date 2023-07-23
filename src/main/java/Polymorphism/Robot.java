package Polymorphism;

public class Robot implements Member {
    private int maxRun;
    private int maxJump;
    private String title = "Робот";

    public Robot(int maxRun, int maxJump) {
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
        System.out.println("Робот біжить");
    }

    @Override
    public void jump() {
        System.out.println("Робот стрибає");
    }
}
