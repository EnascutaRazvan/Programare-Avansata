import controller.CityController;
import controller.ContinentController;
import controller.CountryController;
import entity.Continent;
import entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        ContinentController continentController = new ContinentController(emf);
        CityController cityController = new CityController(emf);
        CountryController countryController = new CountryController(emf);

        Continent continent = new Continent();
        continent.setName("TEST");

        //System.out.println(continentController.findAll());
        //System.out.println(continentController.findById(2));
        System.out.println(cityController.findByName("Bucharest"));
        System.out.println();
        System.out.println(countryController.findById(177));
        System.out.println();
        System.out.println(countryController.findByName("France"));

        Country country = new Country();
        country.setName("TEST");
        country.setCode("AA");
        country.setContinent(continentController.findByName("Africa"));
        countryController.create(country);
    }
}
