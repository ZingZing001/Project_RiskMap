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

    loadMap(); // keep this mehtod invocation
  }

  /** invoked one time only when constracting the MapEngine class. */
  private void loadMap() {
    List<String> countriesRaw = Utils.readCountries();
    List<String> adjacenciesRaw = Utils.readAdjacencies();
    countries = loadC.FormStructure(countriesRaw);
    adjacentCountries = loadA.FormStructure(adjacenciesRaw);
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {

    String country = checkIfCountryValid.getValidCountry(countries);
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}
}
