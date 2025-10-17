package com.example.listycity;

/**
 * This class represents a City.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructs a new City object
     * @param city
     *      name of city
     * @param province
     *      name of province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Getter method for city name
     * @return
     *      name of city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Getter method for province name
     * @return
     *      name of province
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares a city to another City object by city name
     * @param other
     *      the object to be compared
     * @return
     *      negative int, if this.city is before other
     *      zero, if this.city is equal to other
     *      positive int, if this.city is after other
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Determines if a city is equal to another City object
     * @param obj
     *      the object to be compared
     * @return
     *      true, if the cities are equal
     *      false, if the cities are unequal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Returns the hashcode for this.city
     * @return
     *      hash code value for this.city
     */
    @Override
    public int hashCode() {
        return this.city.hashCode() + this.province.hashCode();
    }
}
