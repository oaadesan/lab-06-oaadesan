package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class keeps a list of City objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a City object to the list if it does not exist
     * @param city
     *      This is the candidate City to be added
     * @throws IllegalArgumentException
     *      city already in list
     */
    public void addCity(City city){
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a list of sorted City objects
     * @return
     *      Returns the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city exists in the city list
     * @param city
     *      city to be checked
     * @return
     *      true, if the city is in the list
     *      false, if the city is not in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the city list if it exists
     * @param city
     *      city to be removed
     * @throws IllegalArgumentException
     *      city does not exist in list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Counts the number of cities in the city list
     * @return
     *      number of cities in list
     */
    public int countCities() {
        return cities.size();
    }
}
