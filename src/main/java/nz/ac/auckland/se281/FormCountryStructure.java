package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code FormCountryStructure} class manages the creation of a map structure where each country
 * is represented as a {@code Country} object. This class facilitates the initialization and
 * management of country data from a structured list of country attributes.
 */
public class FormCountryStructure {
  private Map<String, Country>
      Countries; // Stores a map of countries, using the country name as the key.

  /** Constructs a {@code FormCountryStructure} with an empty map to store country objects. */
  public FormCountryStructure() {
    Countries = new HashMap<>();
  }

  /**
   * Initializes the structure of countries by processing a list of strings where each string
   * contains the country's name, continent, and tax rate separated by commas. It creates a new
   * {@code Country} object for each entry and stores it in the map.
   *
   * @param countries a list of strings, each containing a country's name, continent, and tax rate,
   *     formatted as "Name,Continent,Tax". For example, "New Zealand,Oceania,15".
   * @return a map where each key is a country's name and the value is the corresponding {@code
   *     Country} object, fully initialized with name, continent, and tax.
   */
  public Map<String, Country> initializeCountryStructure(List<String> countries) {
    for (String CountriesLine : countries) {
      String[] splited = CountriesLine.split(",");
      String country = splited[0];
      String continent = splited[1];
      int tax = Integer.parseInt(splited[2]);
      Countries.put(country, new Country(country, continent, tax));
    }
    return Countries;
  }
}
