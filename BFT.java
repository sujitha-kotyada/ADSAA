//Java program to find the BFT of a graph with adjacency matrix representation

import java.util.*;

public class BFT{
	private int n; 
    	private int[][] adjMatrix;
     	BFT(int n){
        		this.n = n;
        		adjMatrix = new int[n][n];
    	}
    	void addEdge(int u, int v) {
        		adjMatrix[u][v] = 1;
        		adjMatrix[v][u] = 1;
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

            			for (int i = 0; i < n; i++) {
                				if (adjMatrix[current][i] == 1 && !visited[i]) {
                    				visited[i] = true;
                    				queue.add(i);
                    			}
                    	}
                 }
         }
         public static void main(String[] args){
         		BFT graph=new BFT(5);
         		graph.addEdge(0,1);
         		graph.addEdge(0,2);
         		graph.addEdge(1,3);
         		graph.addEdge(1,4);
         		graph.bft(0);
         }
}
         		
