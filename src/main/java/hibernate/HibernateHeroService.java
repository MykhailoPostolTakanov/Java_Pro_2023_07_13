package hibernate;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@AllArgsConstructor
public class HibernateHeroService {
    private final Session session;

    public HibernateHero findByID(Long id) {
        return session.find(HibernateHero.class, id);
    }

    public List<HibernateHero> findAll() {
        //return session.createQuery("SELECT h FROM hero h", HibernateHero.class).getResultList();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<HibernateHero> cq = cb.createQuery(HibernateHero.class);
        Root<HibernateHero> rootEntry = cq.from(HibernateHero.class);
        CriteriaQuery<HibernateHero> all = cq.select(rootEntry);

        TypedQuery<HibernateHero> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public HibernateHero add(HibernateHero hero) {
        var id = session.save(hero);
        return session.find(HibernateHero.class, id);
    }

    public void delete(HibernateHero hero) {
        session.remove(hero);
    }

    public HibernateHero update(HibernateHero hero) {
        return session.merge(hero);
    }
}
