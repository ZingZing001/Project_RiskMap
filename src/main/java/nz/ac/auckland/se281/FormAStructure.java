package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormAStructure {
  private HashMap<String, List<String>> adjacencyList;

  public FormAStructure() {
    adjacencyList = new HashMap<>();
  }

  public HashMap<String, List<String>> FormStructure(List<String> adjacencies) {
    for (String adjacentCountriesLines : adjacencies) {
      String[] splited = adjacentCountriesLines.split(",");
      String country = splited[0];
      String adjacentCountry = splited[1];
      adjacencyList.computeIfAbsent(country, k -> new ArrayList<>()).add(adjacentCountry);
    }
    return adjacencyList;
  }
}
