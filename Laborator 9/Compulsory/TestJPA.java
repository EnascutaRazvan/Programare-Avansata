package lab9;

import continents.ContinentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {
    public TestJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //ContinentsEntity continent = new ContinentsEntity("Europe");
        //em.persist(continent);

        ContinentsEntity c = (ContinentsEntity) em.createQuery(
                        "select e from ContinentsEntity e where e.name='Europe'")
                .getSingleResult();
        //c.setName("Africa");
        System.out.println(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
