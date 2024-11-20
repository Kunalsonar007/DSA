import java.util.Arrays;

class Dijkstra {

  void dijkstra(int[][] graph, int src) {
    int vertices = graph.length;
    int[] dist = new int[vertices];
    boolean[] visited = new boolean[vertices];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int i = 0; i < vertices - 1; i++) {
      int u = findMinDistance(dist, visited);
      visited[u] = true;

      for (int v = 0; v < vertices; v++) {
        if (
          !visited[v] &&
          graph[u][v] != 0 &&
          dist[u] != Integer.MAX_VALUE &&
          dist[u] + graph[u][v] < dist[v]
        ) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }

    printSolution(dist);
  }

  private int findMinDistance(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE, minIndex = -1;
    for (int i = 0; i < dist.length; i++) {
      if (!visited[i] && dist[i] <= min) {
        min = dist[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  private void printSolution(int[] dist) {
    System.out.println("Vertex\tDistance from Source");
    for (int i = 0; i < dist.length; i++) {
      System.out.println(i + "\t" + dist[i]);
    }
  }

  public static void main(String[] args) {
    int[][] graph = {
      { 0, 10, 0, 30, 100 },
      { 10, 0, 50, 0, 0 },
      { 0, 50, 0, 20, 10 },
      { 30, 0, 20, 0, 60 },
      { 100, 0, 10, 60, 0 },
    };

    Dijkstra d = new Dijkstra();
    d.dijkstra(graph, 0);
  }
}
