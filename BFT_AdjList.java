//BFT of a graph using adjacency list representation
import java.util.*;

public class BFT_AdjList {
    	private int n;
    	private LinkedList<Integer>[] adjList;

    	BFT_AdjList(int n) {
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

    	void bft(int startVertex) {
        		boolean[] visited = new boolean[n];
        		Queue<Integer> queue = new LinkedList<>();

        		visited[startVertex] = true;
        		queue.add(startVertex);

        		System.out.print("Breadth First Traversal: ");

        		while (!queue.isEmpty()) {
            			int current = queue.poll();
            			System.out.print(current + " ");

            			for (int neighbor : adjList[current]) {
                				if (!visited[neighbor]) {
                    				visited[neighbor] = true;
                    				queue.add(neighbor);
                				}
            			}
        		}
    	}

        	public static void main(String[] args) {
        		BFT_AdjList graph = new BFT_AdjList(5);

        		graph.addEdge(0, 1);
        		graph.addEdge(0, 2);
        		graph.addEdge(1, 3);
        		graph.addEdge(1, 4);

        		graph.bft(0);
    	}
}
