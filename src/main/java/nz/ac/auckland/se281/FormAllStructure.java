package nz.ac.auckland.se281;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The {@code FormAllStructure} class is responsible for creating an adjacency list representation
 * of a graph from a list of adjacency relationships. This class can be used to manage and construct
 * the structure of graphs based on country connections.
 */
public class FormAllStructure {
  private Map<String, List<String>> adjacencyList; // stores the adjacency list of the graph

  /** Constructs an empty {@code FormAllStructure} with an empty adjacency list. */
  public FormAllStructure() {
    adjacencyList = new HashMap<>(); // Initialize an empty HashMap to store adjacency list
  }

  /**
   * Adds a new node (country) to the adjacency list if it does not already exist.
   *
   * @param country the node (country) to be added to the adjacency list.
   */
  public void addNode(String country) {
    // Puts the country in the adjacency list if it's not already there, initializing with an empty
    // list
    adjacencyList.putIfAbsent(country, new LinkedList<>());
  }

  /**
   * Processes a list of string representations of adjacency relationships and constructs the
   * adjacency list. Each string in the list should contain a country followed by its adjacent
   * countries separated by commas.
   *
   * @param adjacencies a list of strings, where each string contains a country and its adjacent
   *     countries, separated by commas (e.g., "Country1,Country2,Country3").
   * @return the fully constructed adjacency list as a map, where each key is a country and its
   *     value is a list of adjacent countries.
   */
  public Map<String, List<String>> generateAdjacencyStructure(List<String> adjacencies) {
    for (String adjacentCountriesLines : adjacencies) {
      // Split each line of adjacencies into an array, where the first element is the country
      String[] splited = adjacentCountriesLines.split(",");
      String country = splited[0]; // The first element is the country name
      addNode(country); // Ensure the country is added as a node
      for (int i = 1; i < splited.length; i++) {
        // Add each adjacent country to the list of the main country in the adjacency list
        adjacencyList.get(country).add(splited[i]);
      }
    }
    return adjacencyList; // Return the complete map of countries with their respective adjacencies
  }
}
