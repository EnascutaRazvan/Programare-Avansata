package controller;

import entity.City;

import java.util.List;

public interface CityRepository {
    City get(int id);
    void create(City city);
    City findById(int id);
    List<City> findByName(String name);
}
