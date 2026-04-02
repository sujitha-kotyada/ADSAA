//DFS of graph using Adjacency List
import java.util.*;

public class DFS_AdjList {
    private int n;
    private LinkedList<Integer>[] adjList;

    public DFS_AdjList(int n) {
        this.n = n;
        adjList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void dfs(int startVertex) {
        boolean[] visited = new boolean[n];
        System.out.print("Depth First Traversal: ");
        dfsUtil(startVertex, visited);
    }

    void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String args[]) {
        DFS_AdjList graph = new DFS_AdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.dfs(0);
    }
}
