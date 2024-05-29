package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** This class is the main entry point. */
public class MapEngine {

  private FormCStructure loadC;
  private FormAStructure loadA;
  private Map<String, Country> countries;
  private Map<String, List<String>> adjacentCountries;
  private FindRoute fRoute;
  private CheckUserInput checkUserInput;

  public MapEngine() {
    loadC = new FormCStructure();
    loadA = new FormAStructure();
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
    try {
      String country = getValidCountry();
      String name = countries.get(country).getName();
      String continent = countries.get(country).getContinent();
      String tax = countries.get(country).getTax() + "";
      MessageCli.COUNTRY_INFO.printMessage(name, continent, tax);
    } catch (CountryNotFoundException e) {
      showInfoCountry();
    }
  }

  /** this method is invoked when the user runs the command route. */
  public void showRoute() {
    String startCountry = null;
    String endCountry = null;

    while (startCountry == null) {
      try {
        MessageCli.INSERT_SOURCE.printMessage();
        startCountry = getValidCountry();
      } catch (CountryNotFoundException e) {
        MessageCli.INVALID_COUNTRY.printMessage();
      }
    }

    while (endCountry == null) {
      try {
        MessageCli.INSERT_DESTINATION.printMessage();
        endCountry = getValidCountry();
      } catch (CountryNotFoundException e) {
        MessageCli.INVALID_COUNTRY.printMessage();
      }
      
    }

  private String getValidCountry() throws CountryNotFoundException {
    MessageCli.INSERT_COUNTRY.printMessage();
    String userInput = Utils.scanner.nextLine();
    checkUserInput.checkValidCountry(countries, userInput);
    return Utils.capitalizeFirstLetterOfEachWord(userInput);
  }
}
