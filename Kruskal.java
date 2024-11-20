import java.util.*;

class Kruskal {

  class Edge implements Comparable<Edge> {

    int src, dest, weight;

    public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
    }
  }

  class Subset {

    int parent, rank;
  }

  @SuppressWarnings("unused")
  private int vertices, edges;

  private Edge[] edge;

  Kruskal(int vertices, int edges) {
    this.vertices = vertices;
    this.edges = edges;
    edge = new Edge[edges];
    for (int i = 0; i < edges; i++) {
      edge[i] = new Edge();
    }
  }

  int find(Subset[] subsets, int i) {
    if (subsets[i].parent != i) {
      subsets[i].parent = find(subsets, subsets[i].parent);
    }
    return subsets[i].parent;
  }

  void union(Subset[] subsets, int x, int y) {
    int xRoot = find(subsets, x);
    int yRoot = find(subsets, y);

    if (subsets[xRoot].rank < subsets[yRoot].rank) {
      subsets[xRoot].parent = yRoot;
    } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
      subsets[yRoot].parent = xRoot;
    } else {
      subsets[yRoot].parent = xRoot;
      subsets[xRoot].rank++;
    }
  }

  void kruskalMST() {
    Edge[] result = new Edge[vertices];
    int e = 0;
    int i = 0;

    Arrays.sort(edge);

    Subset[] subsets = new Subset[vertices];
    for (int v = 0; v < vertices; v++) {
      subsets[v] = new Subset();
      subsets[v].parent = v;
      subsets[v].rank = 0;
    }

    while (e < vertices - 1) {
      Edge nextEdge = edge[i++];
      int x = find(subsets, nextEdge.src);
      int y = find(subsets, nextEdge.dest);

      if (x != y) {
        result[e++] = nextEdge;
        union(subsets, x, y);
      }
    }

    System.out.println("Edges in the Minimum Spanning Tree:");
    for (i = 0; i < e; i++) {
      System.out.println(
        result[i].src + " - " + result[i].dest + ": " + result[i].weight
      );
    }
  }

  public static void main(String[] args) {
    int vertices = 4;
    int edges = 5;
    Kruskal graph = new Kruskal(vertices, edges);

    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = 10;

    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 6;

    graph.edge[2].src = 0;
    graph.edge[2].dest = 3;
    graph.edge[2].weight = 5;

    graph.edge[3].src = 1;
    graph.edge[3].dest = 3;
    graph.edge[3].weight = 15;

    graph.edge[4].src = 2;
    graph.edge[4].dest = 3;
    graph.edge[4].weight = 4;

    graph.kruskalMST();
  }
}
