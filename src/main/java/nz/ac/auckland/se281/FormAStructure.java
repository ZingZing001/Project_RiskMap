package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FormAStructure {
  private Map<String, Queue<String>> adjacencyList;

  public FormAStructure() {
    adjacencyList = new HashMap<>();
  }

  public void addNode(String country) {
    adjacencyList.putIfAbsent(country, new LinkedList<>());
  }

  public Map<String, Queue<String>> FormStructure(List<String> adjacencies) {
    for (String adjacentCountriesLines : adjacencies) {
      String[] splited = adjacentCountriesLines.split(",");
      String country = splited[0];
      for (int i = 1; i < splited.length; i++) {
        adjacencyList.get(country).add(splited[i]);
      }
    }
    return adjacencyList;
  }
}
