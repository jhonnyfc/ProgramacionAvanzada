package Práctica5;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Country implements Serializable {

    private String name;
    private String region;
    private long population;
    private long area;
    private long gdp;
    private List<City> cities;

    public Country(String name, String region, long population, long area, long gdp) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
        this.cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void addCity(City city) {
        cities.add(city);
    }

    public static List<Country> parseCSV(String filepath) {

        List<Country> countries = new ArrayList<>();
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            for (String line; (line = br.readLine()) != null;) {
                if (i < 5) {
                    i++;
                    continue;
                }
                String[] split = line.split(",");
                if (split.length >= 9) {
                    if (split[0].contains("\"") ||split[8].isEmpty()) {
                        continue;
                    }
                    String countryName = split[0].trim();
                    String countryRegion = split[1].trim();
                    Long countryPopulation = Long.parseLong(split[2]);
                    Long countryArea = Long.parseLong(split[3]);
                    Long countryGdp = Long.parseLong(split[8]);
                    countries.add(new Country(countryName, countryRegion, countryPopulation, countryArea, countryGdp));
                }
            }
        } catch(IOException ex) {
            System.out.println("Error: " + ex);
        }
        return countries;
    }

    public static List<Country> getCountriesWithHighPopulation(List<Country> countries) {
        List<Country> highPopulationCountries = new ArrayList<>();
        long sumPopulation = 0;
        for(Country country: countries) {
            sumPopulation += country.population;
        }
        long average = sumPopulation / countries.size();
        System.out.println("Average = " + average);
        for(Country country: countries) {
            if (country.population > average) {
                highPopulationCountries.add(country);
                System.out.println(country.name + " - " + country.population);
            }
        }
        return highPopulationCountries;
    }

    public static void showCountriesPerRegion(List<Country> countries) {
        Map<String, Integer> countriesPerRegion = new HashMap<>();
        for(Country country: countries) {
            String region = country.region;
            if (!countriesPerRegion.containsKey(region)) {
                countriesPerRegion.put(region, 0);
            }
            countriesPerRegion.put(region, countriesPerRegion.get(region)+1);
        }

        for(String region: countriesPerRegion.keySet()) {
            System.out.println(region + " - " +  countriesPerRegion.get(region));
        }
    }

    public static void  writeCSV(List<Country> countries) {
        try {
            FileWriter f = new FileWriter("resources/outCountries.csv");
            int i = 0;
            for(Country country: countries) {
                f.write(country.name);
                if (i != (countries.size()-1)) {
                    f.write(",");
                }
                f.write("\n");
                i++;
            }
            f.close();
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void writeObjects(List<Country> countries) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("resources/countriesAndcities.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(Country country: countries) {
                out.writeObject(country);
            }
            System.out.println("Written " + countries.size() + " countries");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Country> readObjects() {
        List<Country> countries = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("resources/countriesAndcities.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
                Object o = in.readObject();
                countries.add((Country) o);
            }
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }


    public long getPopulationDifference() {
        if (cities.size() < 2) {
            return 0;
        }
        long maxPopulation = 0;
        long minPopulation = Long.MAX_VALUE;
        for(City city: cities) {
            if (city.getPopulation() > maxPopulation) {
                maxPopulation = city.getPopulation();
            }else if (city.getPopulation() > 0 && city.getPopulation() < minPopulation) {
                minPopulation = city.getPopulation();
            }
        }
        return maxPopulation - minPopulation;
    }

    public static void writeXML(List<Country> countries) {
        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(countries);
        try {
            Files.write(Paths.get("resources/countries.xml"), xml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // #1
        List<Country> countries = Country.parseCSV("resources/countries.csv");
        // #2
        List<Country> highPopulationCountries = Country.getCountriesWithHighPopulation(countries);
        // #3
        Country.showCountriesPerRegion(countries);

        // #7
        Country.writeCSV(highPopulationCountries);

        // #8
        List<Country> countries2 = Country.parseCSV("resources/countries.csv");
        List<City> cities = City.parseCSV("resources/cities.csv", countries);
        Country.writeObjects(highPopulationCountries);

        List<Country> serializedCountries = Country.readObjects();
        for(Country country: serializedCountries) {
            System.out.println("Country " + country.name + " has " + country.cities.size() + " cities");
            for(City city: country.cities) {
                System.out.println("  " + city);
            }
        }
        // sí que parece que cada pais tiene referencias correctas a sus ciudades

        // %9
        Country.writeXML(countries);

        

    }
}
