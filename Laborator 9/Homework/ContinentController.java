package controller;

import entity.Continent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ContinentController {
    private EntityManagerFactory entityManagerFactory;

    public ContinentController(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Continent continent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(continent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Continent findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Continent c where c.name like :x");

        Continent continent = (Continent) query.setParameter("x", name).getSingleResult();
        entityManager.close();

        return continent;
    }

    public Continent findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Continent c where c.id = :x");

        Continent continent = (Continent) query.setParameter("x", id).getSingleResult();

        return continent;
    }

    public List<Continent> findAll() {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Continent c order by c.name");
        List<Continent> continentList = query.getResultList();

        return continentList;
    }
}
