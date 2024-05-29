package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindRoute {
  private Map<String, List<String>> adjNodes;

  public FindRoute(Map<String, List<String>> map) {
    this.adjNodes = map;
  }

  public List<String> findR_BFS(String start, String des) {
    List<String> visited = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(start);
    visited.add(start);
    while (!queue.isEmpty() && !visited.contains(des)) {
      String node = queue.poll();
      for (String n : adjNodes.get(node)) {
        if (!visited.contains(n)) {
          visited.add(n);
          queue.add(n);
        }
      }
    }
    return visited;
  }
}
