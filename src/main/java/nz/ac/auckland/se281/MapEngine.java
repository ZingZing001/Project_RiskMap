package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The {@code MapEngine} class is the main control center that integrates various components to
 * manage and interact with geographical data about countries and their relationships. It loads and
 * manages country data and adjacency relationships, and provides functionality to display country
 * information and find routes between countries.
 */
public class MapEngine {

  private FormCountryStructure loadCountries; // Handles loading and initialization of country data
  private FormAllStructure loadAll; // Handles generation of adjacency structure for countries
  private Map<String, Country> countries; // Stores country data mapped by country name
  private Map<String, List<String>> adjacentCountries; // Stores adjacency list of countries
  private FindRoute findRoute; // Provides functionality to find routes between countries
  private CheckUserInput checkUserInput; // Validates user input for country names

  /**
   * Initializes the {@code MapEngine} by setting up necessary structures and loading initial data.
   */
  public MapEngine() {
    loadCountries = new FormCountryStructure();
    loadAll = new FormAllStructure();
    countries = new HashMap<>();
    adjacentCountries = new HashMap<>();
    checkUserInput = new CheckUserInput();

    loadMap(); // keep this method invocation
  }

  /**
   * Loads country and adjacency data from external sources and initializes the necessary data
   * structures. This method is called once during the instantiation of {@code MapEngine}.
   */
  private void loadMap() {
    List<String> countriesRaw = Utils.readCountries();
    List<String> adjacenciesRaw = Utils.readAdjacencies();
    countries = loadCountries.initializeCountryStructure(countriesRaw);
    adjacentCountries = loadAll.generateAdjacencyStructure(adjacenciesRaw);
    findRoute = new FindRoute(adjacentCountries);
  }

  /**
   * Displays information about a country based on user input. It loops until valid country input is
   * provided. This method handles user interactions and exceptions internally.
   */
  public void showInfoCountry() {
    boolean validCountry = false;
    while (!validCountry) {
      try {
        MessageCli.INSERT_COUNTRY.printMessage();
        String country = getValidCountry();
        String name = countries.get(country).getName();
        String continent = countries.get(country).getContinent();
        String tax = countries.get(country).getTax() + "";
        MessageCli.COUNTRY_INFO.printMessage(name, continent, tax);
        validCountry = true;
      } catch (CountryNotFoundException e) {
        // Catch block intentionally left empty to loop until valid input is provided
      }
    }
  }

  /**
   * Finds and displays the route between two countries based on user input. It continues prompting
   * the user until valid start and destination countries are provided.
   */
  public void showRoute() {
    Set<String> continentSet;
    String startCountry = null;
    String endCountry = null;
    List<String> list;

    while (startCountry == null) {
      try {
        MessageCli.INSERT_SOURCE.printMessage();
        startCountry = getValidCountry();
      } catch (CountryNotFoundException e) {
        // Catch block intentionally left empty to loop until valid input is provided
      }
    }

    while (endCountry == null) {
      try {
        MessageCli.INSERT_DESTINATION.printMessage();
        endCountry = getValidCountry();
      } catch (CountryNotFoundException e) {
        // Catch block intentionally left empty to loop until valid input is provided
      }
    }
    list = findRoute.breadthFirstSearchRoute(startCountry, endCountry);
    continentSet = new LinkedHashSet<>();
    if (startCountry.equals(endCountry)) {
      MessageCli.NO_CROSSBORDER_TRAVEL.printMessage();
    } else {
      int totalTax = 0;
      MessageCli.ROUTE_INFO.printMessage(list.toString());
      for (String country : list) {
        continentSet.add(countries.get(country).getContinent());
        totalTax += countries.get(country).getTax();
      }
      int selfTax = countries.get(list.get(0)).getTax();
      totalTax -= selfTax;
      MessageCli.CONTINENT_INFO.printMessage(continentSet.toString());
      MessageCli.TAX_INFO.printMessage(totalTax + "");
    }
  }

  /**
   * Helper method to validate the country name input by the user.
   *
   * @return the validated and formatted country name.
   * @throws CountryNotFoundException if the input does not correspond to a valid country.
   */
  private String getValidCountry() throws CountryNotFoundException {
    String userInput = Utils.scanner.nextLine();
    checkUserInput.checkValidCountry(countries, userInput);
    return Utils.capitalizeFirstLetterOfEachWord(userInput);
  }
}
