package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** This class is the main entry point. */
public class MapEngine {

  private FormCStructure loadC;
  private FormAStructure loadA;

  public MapEngine() {
    loadC = new FormCStructure();
    loadA = new FormAStructure();
    loadMap(); // keep this mehtod invocation
  }

  /** invoked one time only when constracting the MapEngine class. */
  private void loadMap() {
    Map<String, Country> Countries = new HashMap<>();
    Map<String, List<String>> adjacentCountries = new HashMap<>();
    List<String> countries = Utils.readCountries();
    List<String> adjacencies = Utils.readAdjacencies();
    Countries = loadC.FormStructure(countries);
    adjacentCountries = loadA.FormStructure(adjacencies);
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {}

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}
}
