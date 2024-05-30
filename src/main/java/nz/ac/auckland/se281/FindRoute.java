package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    Queue<String> queue = new LinkedList<>();
    Map<String, String> par = new HashMap<>();
    queue.add(start);
    par.put(start, null);
    while (!queue.isEmpty()) {
      String node = queue.poll();
      if (node.equals(des)) {
        break;
      }
      for (String n : adjNodes.get(node)) {
        if (!par.containsKey(n)) {
          queue.add(n);
          par.put(n, node);
        }
      }
    }
    List<String> path = new ArrayList<>();
    for (String at = des; at != null; at = par.get(at)) {
      path.add(at);
    }
    Collections.reverse(path);
    return path;
  }
}
