import java.util.*;
import java.util.Queue;

class GraphBFS {

  private int vertices;
  private LinkedList<Integer>[] adjList;

  @SuppressWarnings("unchecked")
  GraphBFS(int vertices) {
    this.vertices = vertices;
    adjList = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  void addEdge(int src, int dest) {
    adjList[src].add(dest);
  }

  void bfs(int start) {
    boolean[] visited = new boolean[vertices];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      System.out.print(vertex + " ");

      for (int neighbor : adjList[vertex]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }

  public static void main(String[] args) {
    GraphBFS graph = new GraphBFS(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);

    System.out.print("BFS Traversal: ");
    graph.bfs(0);
  }
}
