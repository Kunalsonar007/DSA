import java.util.*;

class Prim {

  int minKey(int[] key, boolean[] mstSet, int vertices) {
    int min = Integer.MAX_VALUE, minIndex = -1;

    for (int v = 0; v < vertices; v++) {
      if (!mstSet[v] && key[v] < min) {
        min = key[v];
        minIndex = v;
      }
    }

    return minIndex;
  }

  void primMST(int[][] graph) {
    int vertices = graph.length;
    int[] parent = new int[vertices];
    int[] key = new int[vertices];
    boolean[] mstSet = new boolean[vertices];

    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < vertices - 1; count++) {
      int u = minKey(key, mstSet, vertices);
      mstSet[u] = true;

      for (int v = 0; v < vertices; v++) {
        if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
      }
    }

    printSolution(parent, graph);
  }

  void printSolution(int[] parent, int[][] graph) {
    System.out.println("Edge\tWeight");
    for (int i = 1; i < graph.length; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
  }

  public static void main(String[] args) {
    int[][] graph = {
      { 0, 2, 0, 6, 0 },
      { 2, 0, 3, 8, 5 },
      { 0, 3, 0, 0, 7 },
      { 6, 8, 0, 0, 9 },
      { 0, 5, 7, 9, 0 },
    };

    Prim p = new Prim();
    p.primMST(graph);
  }
}
