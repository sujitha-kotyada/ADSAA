//DFS Traversal of a Graph with Adjacency Matric Representation
import java.util.Scanner;

class DFS{
	int n;
	int[][] adj;
	boolean[] visited;
	DFS(int n){
		this.n=n;
		adj=new int[n][n];
		visited=new boolean[n];
	}
	void addEdge(int u,int v){
		adj[u][v]=1;
		adj[v][u]=1;
	}
	void dfs(int v){
		visited[v]=true;
		System.out.print(v+" ");
		for(int i=0;i<n;i++){
			if(adj[v][i]==1 && !visited[i]){
					dfs(i);
			}
		}
	}
	public static void main(String[] args){
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter no.of vertices:");
			int n=sc.nextInt();
			DFS graph=new DFS(n);
			System.out.print("Enter no.of Edges:");
			int e=sc.nextInt();
			System.out.println("Enter edges (u,v) :");
			for(int i=0;i<e;i++){
			}
	}
			
