package Práctica5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class City implements Serializable {
    private String city;
    private String country;
    private Country countryRef;
    private long population;

    public City(String city, String country, Country countryRef, long population) {
        this.city = city;
        this.country = country;
        this.countryRef = countryRef;
        this.population = population;
    }

    @Override
    public String toString() {
        return city + " - " + countryRef.getName() + " - " + population;
    }

    public long getPopulation() {
        return population;
    }

    public static List<City> parseCSV(String path, List<Country> countries) {
        Map<String, Country> countriesByName = toMap(countries);
        List<City> cities = new ArrayList<>();
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line; (line = br.readLine()) != null;) {
                if (i < 1) {
                    i++;
                    continue;
                }
                String[] split = line.split(",");
                if (split.length >= 10) {
                    if (split[9].isEmpty()) {
                        System.out.println(split[0] + " no population included");
                        continue;
                    }
                    String cityName = split[0];
                    String countryName = split[4];
                    Long cityPopulation = null;
                    try {
                        Double aux = Double.parseDouble(split[9]);
                        cityPopulation = aux.longValue();
                    } catch(NumberFormatException e ) {
                        System.out.println(split[0] + " wrong population format: " + split[9]);
                        continue;
                    }
                    Country country = countriesByName.get(countryName);
                    City city = new City(cityName, countryName, country, cityPopulation);
                    if (country != null) {
                        country.addCity(city);
                    } else {
                        System.out.println("Country " + countryName + " not found");
                    }
                    cities.add(city);
                }
            }
        } catch(IOException ex) {
            System.out.println("Error: " + ex);
        }
        return cities;
    }

    private static void print10MostPopulatedCities(List<City> cities) {
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return (int) (o2.population - o1.population);
            }
        });
        for (int i = 0; i < 10; i++) {
            City city = cities.get(i);
            System.out.println(city.city + " - " + city.country + " - " + city.population);
        }
    }

    private static void printCountryWithBiggestPopulationDifference(List<Country> countries) {
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return (int) (o2.getPopulationDifference() - o1.getPopulationDifference());
            }
        });
        System.out.println(countries.get(0).getName() + " has a difference of " + countries.get(0).getPopulationDifference());
    }


    private static Map<String,Country> toMap(List<Country> countries) {
        Map<String, Country> countryMap = new HashMap<>();
        for(Country country: countries) {
            countryMap.put(country.getName(), country);
        }
        return countryMap;
    }

    public static void main(String[] args) {
        // #4
        List<Country> countries = Country.parseCSV("resources/countries.csv");
        List<City> cities = City.parseCSV("resources/cities.csv", countries);
        // #5
        City.print10MostPopulatedCities(cities);
        // #6
        City.printCountryWithBiggestPopulationDifference(countries);
    }
}
