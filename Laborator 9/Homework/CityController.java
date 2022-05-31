package controller;

import entity.City;
import entity.Continent;
import entity.City;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class CityController {
    private EntityManagerFactory entityManagerFactory;

    public CityController(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(City city) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<City> findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from City c where c.name like :x");

        List<City> cityList = query.setParameter("x", name).getResultList();
        entityManager.close();

        return cityList.isEmpty() ? null : cityList;
    }

    public City findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from City c where c.id = :x");

        City city = (City) query.setParameter("x", id).getSingleResult();

        return city;
    }

    public List<City> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from City c order by c.name");
        List<City> cityList = query.getResultList();

        return cityList;
    }

    public List<City> findByCountryId(int countryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select c from City c where c.country.id = :countryId");

        List<City> cityList = query.setParameter("countryId", countryId).getResultList();
        entityManager.close();

        return cityList.isEmpty() ? null : cityList;
    }

}
