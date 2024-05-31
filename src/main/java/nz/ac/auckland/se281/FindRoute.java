package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * The {@code FindRoute} class represents a graph using adjacency list representation and provides a
 * method to find the shortest path between two nodes using the breadth-first search (BFS)
 * algorithm.
 */
public class FindRoute {
  private Map<String, List<String>> adjNodes; // adjacency list representation of the graph

  /**
   * Constructs a {@code FindRoute} object with a specified adjacency list map.
   *
   * @param map the map representing the adjacency list of the graph, where each key is a node and
   *     the corresponding value is a list of adjacent nodes.
   */
  public FindRoute(Map<String, List<String>> map) {
    this.adjNodes = map; // Initialize the adjacency list with the provided map
  }

  /**
   * Performs a breadth-first search (BFS) to find the shortest path from a start node to a
   * destination node. It tracks visited nodes and parent nodes to reconstruct the path once the
   * destination is reached.
   *
   * @param start the starting node for the BFS.
   * @param des the destination node to which the shortest path is sought.
   * @return a list of strings representing the nodes in the path from the start node to the
   *     destination node, in order from start to destination. If no path is found, returns an empty
   *     list.
   */
  public List<String> breadthFirstSearchRoute(String start, String des) {
    Queue<String> queue = new LinkedList<>(); // Queue to manage the nodes for BFS
    Map<String, String> par = new HashMap<>(); // Map to store the parent of each node
    Set<String> visited = new HashSet<>(); // Set to track visited nodes
    queue.add(start); // Enqueue the starting node
    par.put(start, null); // Starting node has no parent

    while (!queue.isEmpty()) { // Continue until there are no nodes left to visit
      String node = queue.poll(); // Dequeue the next node
      visited.add(node); // Mark the node as visited
      if (node.equals(des)) { // Check if the destination node is reached
        break;
      }
      for (String n : adjNodes.get(node)) { // Iterate over all adjacent nodes
        if (!visited.contains(n)
            && !par.containsKey(n)) { // If not visited and not already in queue
          queue.add(n); // Enqueue the node
          par.put(n, node); // Set the current node as its parent
        }
      }
    }
    List<String> path = new ArrayList<>(); // List to store the path from start to destination
    for (String at = des;
        at != null;
        at = par.get(at)) { // Reconstruct the path by following parent nodes
      path.add(at); // Add the node to the path
    }
    Collections.reverse(path); // Reverse the path to get it from start to destination
    return path; // Return the path
  }
}
