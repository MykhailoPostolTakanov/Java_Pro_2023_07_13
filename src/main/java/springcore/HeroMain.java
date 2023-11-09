package springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import patternsandtesting.HeroService;

public class HeroMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        var heroService = context.getBean(HeroService.class);
        System.out.println(heroService.getHeroesByID(14L));
    }
}
