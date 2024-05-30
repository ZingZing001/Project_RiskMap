package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** This class is the main entry point. */
public class MapEngine {

  private FormCountryStructure loadC;
  private FormAllStructure loadA;
  private Map<String, Country> countries;
  private Map<String, List<String>> adjacentCountries;
  private FindRoute fRoute;
  private CheckUserInput checkUserInput;

  public MapEngine() {
    loadC = new FormCountryStructure();
    loadA = new FormAllStructure();
    countries = new HashMap<>();
    adjacentCountries = new HashMap<>();
    checkUserInput = new CheckUserInput();

    loadMap(); // keep this method invocation
  }

  /** invoked one time only when constructing the MapEngine class. */
  private void loadMap() {
    List<String> countriesRaw = Utils.readCountries();
    List<String> adjacenciesRaw = Utils.readAdjacencies();
    countries = loadC.FormStructure(countriesRaw);
    adjacentCountries = loadA.FormStructure(adjacenciesRaw);
    fRoute = new FindRoute(adjacentCountries);
  }

  /** this method is invoked when the user runs the command info-country. */
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

  /** this method is invoked when the user runs the command route. */
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
    list = fRoute.findR_BFS(startCountry, endCountry);
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

  private String getValidCountry() throws CountryNotFoundException {
    String userInput = Utils.scanner.nextLine();
    checkUserInput.checkValidCountry(countries, userInput);
    return Utils.capitalizeFirstLetterOfEachWord(userInput);
  }
}
