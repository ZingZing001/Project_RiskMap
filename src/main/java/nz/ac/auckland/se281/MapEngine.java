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
  private CheckIfCountryValid checkIfCountryValid;

  public MapEngine() {
    loadC = new FormCStructure();
    loadA = new FormAStructure();
    countries = new HashMap<>();
    adjacentCountries = new HashMap<>();
    checkIfCountryValid = new CheckIfCountryValid();

    loadMap(); // keep this method invocation
  }

  /** invoked one time only when constructing the MapEngine class. */
  private void loadMap() {
    List<String> countriesRaw = Utils.readCountries();
    List<String> adjacenciesRaw = Utils.readAdjacencies();
    countries = loadC.FormStructure(countriesRaw);
    adjacentCountries = loadA.FormStructure(adjacenciesRaw);
  }

  /** this method is invoked when the user runs the command info-country. */
  public void showInfoCountry() {
    checkIfCountryValid.getValidCountry(countries);
  }

  /** this method is invoked when the user runs the command route. */
  public void showRoute() {
    String startCountry = getValidCountry();
    String endCountry = getValidCountry();
  }

  private String getValidCountry() {
    String userInput = null;
    boolean validCountry = false;
    MessageCli.INSERT_SOURCE.printMessage();
    while (!validCountry) {
      userInput = Utils.scanner.nextLine();
      try {
        userInput = userInput.strip();
        checkIfCountryValid.getValidCountry(countries);
        validCountry = true;
      } catch (CountryNotFoundException e) {
        MessageCli.INVALID_COUNTRY.printMessage(Utils.capitalizeFirstLetterOfEachWord(userInput));
      }
    }
    return userInput;
  }
}
