class FloydWarshall {

  void floydWarshall(int[][] graph) {
    int vertices = graph.length;
    int[][] dist = new int[vertices][vertices];

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        dist[i][j] = graph[i][j];
      }
    }

    for (int k = 0; k < vertices; k++) {
      for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
          if (dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    printSolution(dist);
  }

  private void printSolution(int[][] dist) {
    System.out.println("Shortest distances between every pair of vertices:");
    for (int[] row : dist) {
      for (int val : row) {
        System.out.print((val == Integer.MAX_VALUE ? "INF" : val) + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int INF = Integer.MAX_VALUE;
    int[][] graph = {
      { 0, 3, INF, INF },
      { 2, 0, INF, INF },
      { INF, 7, 0, 1 },
      { 6, INF, INF, 0 },
    };

    FloydWarshall fw = new FloydWarshall();
    fw.floydWarshall(graph);
  }
}
