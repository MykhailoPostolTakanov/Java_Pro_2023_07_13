package hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        var sessionFactory = context.getBean(SessionFactory.class);
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            var hibernateHeroService = new HibernateHeroService(session);
            System.out.println(hibernateHeroService.findByID(747L));
            var addedHero = hibernateHeroService.add(HibernateHero.builder()
                    .name("Test Hibernate")
                    .gender("Male")
                    .eyeColor("Tested Hibernated Eye Color")
                    .race("Human")
                    .hairColor("Red")
                    .height(196.6)
                    .publisher("Misha Comics")
                    .build());
            System.out.println(addedHero);
            var heroForUpdated = HibernateHero.builder()
                    .id(addedHero.getId())
                    .name(addedHero.getName() + " 2")
                    .gender(addedHero.getGender() + " 2")
                    .eyeColor(addedHero.getEyeColor() + " 2")
                    .race(addedHero.getRace() + " 2")
                    .hairColor(addedHero.getHairColor() + " 2")
                    .height(197)
                    .publisher(addedHero.getPublisher() + " 2")
                    .build();
            var updatedHero = hibernateHeroService.update(heroForUpdated);
            System.out.println(updatedHero);
            hibernateHeroService.delete(updatedHero);
            System.out.println(hibernateHeroService.findAll());
            transaction.commit();
        }
    }
}
