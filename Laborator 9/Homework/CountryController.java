package controller;

import entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class CountryController {
    private EntityManagerFactory entityManagerFactory;

    public CountryController(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Country country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Country findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Country c where c.name like :x");

        Country country = (Country) query.setParameter("x", name).getSingleResult();
        entityManager.close();

        return country;
    }

    public Country findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Country c where c.id = :x");

        Country country = (Country) query.setParameter("x", id).getSingleResult();

        return country;
    }

    public List<Country> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Country c order by c.name");
        List<Country> countryList = query.getResultList();

        return countryList;
    }

    public List<Country> findByContinentId(int continentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from Country c where c.continent.id = :continentId ");

        List<Country> countryList = query.setParameter("continentId", continentId).getResultList();
        entityManager.close();

        return countryList.isEmpty() ? null : countryList;
    }
}
