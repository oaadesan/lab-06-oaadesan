package com.example.listycity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CityListTest {
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.addCity(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "NWT");
        cityList.addCity(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "PEI");
        cityList.addCity(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // Assert already existing city - should return true
        assertTrue(cityList.hasCity(mockCity()));

        // Assert non-existing city - should return false
        City city = new City("Red Deer", "AB");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        // Case 1: city in list
        City city1= new City("Leduc", "AB");
        cityList.addCity(city1);

        // Check that city is present
        assertTrue(cityList.hasCity(city1));

        // Delete city
        cityList.delete(city1);

        // Verify deletion
        assertFalse(cityList.hasCity(city1));
        assertEquals(1, cityList.getCities().size());

        // Case 2: city not in list
        City city2 = new City("Medicine Hat", "AB");

        // Check that city is not present
        assertFalse(cityList.hasCity(city2));

        // Verify exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city2);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        // Should contain only initial mock city
        assertEquals(1, cityList.countCities());

        City city1 = new City("Winnipeg", "MB");
        City city2 = new City("Calgary", "AB");
        City city3 = new City("Moncton", "NB");

        cityList.addCity(city1);
        cityList.addCity(city2);
        cityList.addCity(city3);
        cityList.delete(city2);

        // Should contain 3 cities: mock city, city1, and city3
        assertEquals(3, cityList.countCities());
    }
}
