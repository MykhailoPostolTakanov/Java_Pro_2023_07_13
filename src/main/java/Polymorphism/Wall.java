package Polymorphism;

public class Wall implements Obstacle {
    private int height;
    private String title = "Стіна";

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean overcome(Member member) {
        if (member.getMaxJump() >= height) {
            System.out.println("Учасник " + member.getTitle() + " перестрибнув перешкоду " + title + " на висоті " + height + ".");
            return true;
        } else {
            System.out.println("Учасник " + member.getTitle() + " не перестрибнув перешкоду " + title + " на висоті " + height + ". Стрибок " + member.getMaxJump() + ".");
            return false;
        }
        /*before completion tasks with stars
        * if (member instanceof Human)
            System.out.println("Людина перестрибнула стіну.");
        if (member instanceof Cat)
            System.out.println("Кіт перестрибнув стіну.");
        if (member instanceof Robot)
            System.out.println("Робот перестрибнув стіну.");*/
    }
}
