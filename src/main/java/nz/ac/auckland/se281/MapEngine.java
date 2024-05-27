package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;

/** This class is the main entry point. */
public class MapEngine {

  private HashMap<String, List<String>> adjacencyList;

  public MapEngine() {
    // add other code here if you want
    adjacencyList = new HashMap<>();
    Countries = new HashMap<>();
    loadMap(); // keep this mehtod invocation
  }

  /** invoked one time only when constracting the MapEngine class. */
  private void loadMap() {
    List<String> countries = Utils.readCountries();
    List<String> adjacencies = Utils.readAdjacencies();

    for (String adjacentCountriesLines : adjacencies) {
      String[] splited = adjacentCountriesLines.split(",");
    }
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {
    // add code here
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}
}
