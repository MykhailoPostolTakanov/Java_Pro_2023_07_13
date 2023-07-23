package Polymorphism;

public class Racetrack implements Obstacle {
    private int width;
    private String title = "Бігова Доріжка";

    public Racetrack(int width) {
        this.width = width;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean overcome(Member member) {
        if (member.getMaxRun() >= width) {
            System.out.println("Учасник " + member.getTitle() + " пройшов перешкоду " + title + " на дистанції " + width + ".");
            return true;
        } else {
            System.out.println("Учасник " + member.getTitle() + " не пройшов перешкоду " + title + " на дистанції " + width + ". Пройдено " + member.getMaxRun() + ".");
            return false;
        }
        /*before completion tasks with stars
        * if (member instanceof Human)
            System.out.println("Людина пробігла бігову дорожку.");
        if (member instanceof Cat)
            System.out.println("Кіт пробіг бігову дорожку.");
        if (member instanceof Robot)
            System.out.println("Робот пробіг бігову дорожку.");*/
    }
}
