package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;

/** This class is the main entry point. */
public class MapEngine {
  private HashMap<String, Country> Countries;
  private HashMap<String, List<String>> adjacencyList;

  public MapEngine() {
    // add other code here if you want
    adjacencyList = new HashMap<>();
    loadMap(); // keep this mehtod invocation
  }

  /** invoked one time only when constracting the MapEngine class. */
  private void loadMap() {
    List<String> countries = Utils.readCountries();
    List<String> adjacencies = Utils.readAdjacencies();
    for (String CountriesLine : countries) {
      String[] splited = CountriesLine.split(",");
      String country = splited[0];
      String continent = splited[1];
      int tax = Integer.parseInt(splited[2]);
      Countries.put(country, new Country(country, continent, tax));
    }

    // add code here to create your data structures
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {
    // add code here
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}
}
